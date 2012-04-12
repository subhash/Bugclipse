package com.bugclipse.fogbugz.ui.search;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUiPlugin;
import org.eclipse.mylyn.tasks.ui.search.AbstractRepositoryQueryPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.bugclipse.fogbugz.core.FogBugzConstants;
import com.bugclipse.fogbugz.core.FogBugzCorePlugin;
import com.bugclipse.fogbugz.core.FogBugzSearchQuery;
import com.bugclipse.fogbugz.ui.FogBugzUiPlugin;

public class FogBugzSearchPage extends AbstractRepositoryQueryPage {

	private static final String TITLE_FOGBUGZ_QUERY = "FogBugz Query";

	private Combo searchText;

	private Text titleText;

	private boolean firstTime = true;

	private boolean restoreQueryOptions = true;

	protected final static String PAGE_NAME = "FogBugzSearchPage";

	private IDialogSettings fDialogSettings;

	private static final String STORE_SEARCHPATTERN_ID = PAGE_NAME
			+ ".SEARCHPATTERN";

	private static ArrayList<String> previousSearchPatterns = new ArrayList<String>(
			20);

	public FogBugzSearchPage() {
		super(TITLE_FOGBUGZ_QUERY);
	}

	public FogBugzSearchPage(TaskRepository repository) {
		super(TITLE_FOGBUGZ_QUERY);
		this.repository = repository;
	}

	@Override
	public void createControl(Composite parent) {
		Composite c = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		if (inSearchContainer()) {
			layout.marginWidth = 0;
			layout.marginHeight = 0;
		}
		c.setLayout(layout);
		c.setLayoutData(new GridData(GridData.FILL_BOTH));
		createTitleGroup(c);
		final Label searchTextLabel = new Label(c, SWT.NONE);
		searchTextLabel.setText("&Search Text:");
		searchText = new Combo(c, SWT.SINGLE | SWT.BORDER);
		searchText
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		searchText.addModifyListener(new ModifyListenerImplementation());
		searchText.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleWidgetSelected(searchText, previousSearchPatterns);
			}
		});
		setControl(c);
	}

	private void handleWidgetSelected(Combo widget, ArrayList<String> history) {
		if (widget.getSelectionIndex() < 0)
			return;
		int index = history.size() - 1 - widget.getSelectionIndex();
		String pattern = history.get(index);
		if (pattern == null || !widget.getText().equals(pattern))
			return;
		widget.setText(pattern);
	}

	private void createTitleGroup(Composite control) {
		if (inSearchContainer()) {
			return;
		}

		Label titleLabel = new Label(control, SWT.NONE);
		titleLabel.setText(TITLE_FOGBUGZ_QUERY);

		titleText = new Text(control, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		gd.horizontalSpan = 3;
		titleText.setLayoutData(gd);
		titleText.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				// ignore
			}

			public void keyReleased(KeyEvent e) {
				getContainer().updateButtons();
			}
		});
	}

	private final class ModifyListenerImplementation implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			if (isControlCreated()) {
				setPageComplete(isPageComplete());
			}
		}
	}

	private boolean canQuery() {
		if (isControlCreated()) {
			return searchText.getText().length() > 0;
		} else {
			return false;
		}
	}

	@Override
	public boolean isPageComplete() {
		return getWizard() == null ? canQuery() : canQuery()
				&& super.isPageComplete();
	}

	@Override
	public void setPageComplete(boolean complete) {
		super.setPageComplete(complete);
		if (scontainer != null) {
			scontainer.setPerformActionEnabled(complete);
		}
	}

	@Override
	public AbstractRepositoryQuery getQuery() {
		return new FogBugzSearchQuery(repository.getUrl(), getQueryTitle(),
				searchText.getText());
	}

	@Override
	public boolean performAction() {
		if (restoreQueryOptions) {
			saveState();
		}
		getPatternData(searchText, previousSearchPatterns);
		FogBugzUiPlugin.getDefault().getPreferenceStore().setValue(
				FogBugzConstants.MOST_RECENT_QUERY, searchText.getText());
		return super.performAction();
	}

	private String getPatternData(Combo widget,
			ArrayList<String> previousSearchQueryData) {
		String pattern = widget.getText();
		if (pattern == null || pattern.trim().equals("")) {
			return null;
		}
		String match = null;
		int i = previousSearchQueryData.size() - 1;
		while (i >= 0) {
			match = previousSearchQueryData.get(i);
			if (pattern.equals(match)) {
				break;
			}
			i--;
		}
		if (i >= 0 && match != null) {
			previousSearchQueryData.remove(match);
		} else {
			match = new String(widget.getText());
		}
		previousSearchQueryData.add(match);
		return match;
	}

	public boolean isRestoreQueryOptions() {
		return restoreQueryOptions;
	}

	public void setRestoreQueryOptions(boolean restoreQueryOptions) {
		this.restoreQueryOptions = restoreQueryOptions;
	}

	@Override
	public void saveState() {
		String repoId = "." + repository.getUrl();
		IDialogSettings settings = getDialogSettings();
		settings.put(STORE_SEARCHPATTERN_ID + repoId, searchText.getText());
	}

	public IDialogSettings getDialogSettings() {
		IDialogSettings settings = FogBugzUiPlugin.getDefault()
				.getDialogSettings();
		fDialogSettings = settings.getSection(PAGE_NAME);
		if (fDialogSettings == null)
			fDialogSettings = settings.addNewSection(PAGE_NAME);
		return fDialogSettings;
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible && searchText != null) {
			if (firstTime) {
				if (repository == null) {
					repository = TasksUiPlugin.getRepositoryManager()
							.getDefaultRepository(
									FogBugzCorePlugin.REPOSITORY_KIND);
				}
				firstTime = false;
				for (String searchPattern : getPreviousPatterns(previousSearchPatterns)) {
					searchText.add(searchPattern);
				}
			}
			setPageComplete(isPageComplete());
			if (getWizard() == null) {
				searchText.setFocus();
			}
		}

		super.setVisible(visible);
	}

	private String[] getPreviousPatterns(ArrayList<String> patternHistory) {
		int size = patternHistory.size();
		String[] patterns = new String[size];
		for (int i = 0; i < size; i++)
			patterns[i] = (patternHistory.get(size - 1 - i));
		return patterns;
	}
}
