package com.bugclipse.fogbugz.ui.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUiPlugin;
import org.eclipse.mylyn.tasks.ui.search.AbstractRepositoryQueryPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.bugclipse.fogbugz.api.Filter;
import com.bugclipse.fogbugz.api.client.FogBugzClient;
import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.core.FogBugzRepositoryConnector;
import com.bugclipse.fogbugz.core.FogBugzRepositoryQuery;
import com.bugclipse.fogbugz.model.FogBugzFilter;

public class FogBugzQueryPage extends AbstractRepositoryQueryPage {

	private Table table;

	public FogBugzQueryPage(TaskRepository repository) {
		super("Select query");
		setTitle("Select query");
		setDescription("Select one of the following filters");
		this.repository = repository;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout());
		//
		setControl(container);

		final TableViewer tableViewer = new TableViewer(container,
				SWT.FULL_SELECTION | SWT.BORDER);
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent e) {
						setPageComplete(isPageComplete());
					}
				});
		tableViewer.addOpenListener(new IOpenListener() {
			public void open(OpenEvent event) {
				getWizard().performFinish();
				((WizardDialog) getWizard().getContainer()).close();
			}
		});
		tableViewer.setContentProvider(new ContentProvider());

		tableViewer.setLabelProvider(new TableLabelProvider());
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn queryColumn = new TableColumn(table, SWT.NONE);
		queryColumn.setWidth(147);
		queryColumn.setText("Query");

		final TableColumn descColumn = new TableColumn(table, SWT.NONE);
		descColumn.setWidth(315);
		descColumn.setText("Description");
		try {
			ProgressMonitorDialog monitorDialog = new ProgressMonitorDialog(
					getContainer().getShell());
			GetFiltersOperation operation = new GetFiltersOperation(false);
			monitorDialog.run(true, true, operation);
			tableViewer.setInput(operation.filters);
		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof RuntimeException) {
				MessageDialog.openError(getContainer().getShell(), "Error", e
						.getCause().getCause().getMessage());
			} else {
				MessageDialog.openError(getContainer().getShell(), "Error", e
						.getMessage());
			}
		} catch (InterruptedException e) {
			MessageDialog.openInformation(getContainer().getShell(),
					"Cancelled", e.getMessage());
		}
	}

	@Override
	public boolean isPageComplete() {
		TableItem[] sel = table.getSelection();
		if (sel == null || sel.length == 0) {
			// setErrorMessage("Select a query");
			return false;
		}
		return true;
	}

	@Override
	public AbstractRepositoryQuery getQuery() {
		TableItem[] sel = table.getSelection();
		if (sel != null || sel.length > 0) {
			Object selData = sel[0].getData();
			if (selData instanceof FogBugzFilter) {
				FogBugzFilter f = (FogBugzFilter) selData;
				return new FogBugzRepositoryQuery(repository.getUrl(), f
						.getUrl(), f.getName());
			}
			if (selData instanceof Filter) {
				return new FogBugzRepositoryQuery(repository.getUrl(),
						(Filter) selData);
			}
		}
		return null;
	}

	// public ArrayList<FogBugzFilter> getFilters(TaskRepository repository,
	// IProgressMonitor monitor) throws InterruptedException {
	// ArrayList<FogBugzFilter> results = new ArrayList<FogBugzFilter>();
	// try {
	// FogBugzRepositoryConnector.performFilterQuery(
	// FogBugzConstants.URL_MANAGE_FILTERS,
	// FogBugzConstants.PATTERN_EXTRACT_FILTERS, repository,
	// results, monitor);
	// FogBugzRepositoryConnector.performDefaultFilterQuery(
	// FogBugzConstants.URL_HOME_PAGE,
	// FogBugzConstants.PATTERN_EXTRACT_DEFAULT_FILTERS,
	// repository, results, monitor);
	// return results;
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return results;
	// }

	public Filter[] getFilters(TaskRepository repository,
			IProgressMonitor monitor) throws InterruptedException,
			FogBugzClientException {
		final AbstractRepositoryConnector connector = TasksUiPlugin
				.getRepositoryManager().getRepositoryConnector(
						repository.getConnectorKind());
		final FogBugzClient client = ((FogBugzRepositoryConnector) connector)
				.getClientManager().getClient(repository);
		return client.getFilters(monitor);
	}

	/**
	 * This class represents a progress-monitored operation
	 */
	class GetFiltersOperation implements IRunnableWithProgress {
		// The total execution time
		private static final int TOTAL_TIME = 200;

		private boolean indeterminate;

		private Filter[] filters = new Filter[0];

		/**
		 * LongRunningOperation constructor
		 * 
		 * @param indeterminate
		 *            whether the animation is unknown
		 */
		public GetFiltersOperation(boolean indeterminate) {
			this.indeterminate = indeterminate;
		}

		/**
		 * Runs the long running operation
		 * 
		 * @param monitor
		 *            the progress monitor
		 */
		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			monitor.beginTask("Fetching filters from repository",
					indeterminate ? IProgressMonitor.UNKNOWN : TOTAL_TIME);
			try {
				filters = getFilters(repository, monitor);
			} catch (FogBugzClientException e) {
				throw new RuntimeException(e);
			}
			monitor.done();
			if (monitor.isCanceled())
				throw new InterruptedException(
						"The query operation was cancelled");
		}
	}
}

class ContentProvider implements IStructuredContentProvider {

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ArrayList) {
			return ((ArrayList<FogBugzFilter>) inputElement)
					.toArray(new FogBugzFilter[0]);
		}
		if (inputElement instanceof Filter[])
			return (Filter[]) inputElement;
		return new Object[0];
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}

class TableLabelProvider extends LabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof String[]) {
			String[] s = (String[]) element;
			return s[columnIndex];
		}
		if (element instanceof FogBugzFilter) {
			FogBugzFilter f = (FogBugzFilter) element;
			switch (columnIndex) {
			case 0:
				return f.getName();
			case 1:
				return f.getDescription();
			default:
				break;
			}
		}
		if (element instanceof Filter) {
			Filter f = (Filter) element;
			switch (columnIndex) {
			case 0:
				return f.getContent();
			case 1:
				return f.getType();
			default:
				break;
			}
		}
		return element.toString();
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

}
