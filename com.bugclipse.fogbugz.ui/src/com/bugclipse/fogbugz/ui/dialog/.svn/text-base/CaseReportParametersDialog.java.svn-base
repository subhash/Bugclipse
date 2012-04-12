package com.bugclipse.fogbugz.ui.dialog;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.bugclipse.fogbugz.core.FogBugzAttributeFactory.FogBugzAttribute;

public class CaseReportParametersDialog extends TitleAreaDialog {

	private Text fileName;

	private Button selectAllButton, deselectAllButton;

	private String fileLocation;

	String fileExtension;

	private ArrayList<CaseDialogButton> columns = new ArrayList<CaseDialogButton>();

	private ArrayList<String> selectedAttributes = new ArrayList<String>();

	public String getFileLocation() {
		return fileLocation;
	}

	/**
	 * Create the dialog
	 * 
	 * @param parentShell
	 */
	public CaseReportParametersDialog(Shell parentShell, String format) {
		super(parentShell);
		this.fileExtension = format;
	}

	/**
	 * Create contents of the dialog
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Group group = new Group(container, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 4;
		group.setLayout(gridLayout_1);

		final Button titleButton = new Button(group, SWT.CHECK);
		titleButton.setSelection(true);
		titleButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false));
		titleButton.setText("Title");

		final Button descriptionButton = new Button(group, SWT.CHECK);
		descriptionButton.setSelection(true);
		descriptionButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				true, false));
		descriptionButton.setText("Description");

		final Button statusButton = new Button(group, SWT.CHECK);
		statusButton.setSelection(true);
		statusButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false));
		statusButton.setText("Status");

		final Button currEstButton = new Button(group, SWT.CHECK);
		currEstButton.setSelection(true);
		currEstButton.setText("Current Estimate");

		final Button dueButton = new Button(group, SWT.CHECK);
		dueButton.setSelection(true);
		dueButton.setText("Due");

		final Button priorityButton = new Button(group, SWT.CHECK);
		priorityButton.setSelection(true);
		priorityButton.setText("Priority");

		final Button projectButton = new Button(group, SWT.CHECK);
		projectButton.setSelection(true);
		projectButton.setText("Project");

		final Button areaButton = new Button(group, SWT.CHECK);
		areaButton.setSelection(true);
		areaButton.setText("Area");

		final Button fixForButton = new Button(group, SWT.CHECK);
		fixForButton.setSelection(true);
		fixForButton.setText("Fix For");

		final Button categoryButton = new Button(group, SWT.CHECK);
		categoryButton.setSelection(true);
		categoryButton.setText("Category");

		final Button computerButton = new Button(group, SWT.CHECK);
		computerButton.setSelection(true);
		computerButton.setText("Computer");

		final Button versionButton = new Button(group, SWT.CHECK);
		versionButton.setSelection(true);
		versionButton.setText("Version");

		final Button assignedToButton = new Button(group, SWT.CHECK);
		assignedToButton.setSelection(true);
		assignedToButton.setText("Assigned To");

		final Button openedByButton = new Button(group, SWT.CHECK);
		openedByButton.setSelection(true);
		openedByButton.setText("Opened By");

		final Button openedOnButton = new Button(group, SWT.CHECK);
		openedOnButton.setSelection(true);
		openedOnButton.setText("Opened On");

		final Button lastUpdatedOnButton = new Button(group, SWT.CHECK);
		lastUpdatedOnButton.setSelection(true);
		lastUpdatedOnButton.setText("Last Updated On");

		final Button ccButton = new Button(group, SWT.CHECK);
		ccButton.setSelection(true);
		ccButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
				2, 1));
		ccButton.setText("CC");

		columns.add(new CaseDialogButton(titleButton, FogBugzAttribute.TITLE
				.getKey()));
		columns.add(new CaseDialogButton(descriptionButton,
				FogBugzAttribute.DESCRIPTION.getKey()));
		columns.add(new CaseDialogButton(statusButton, FogBugzAttribute.STATUS
				.getKey()));
		columns.add(new CaseDialogButton(currEstButton,
				FogBugzAttribute.CURRENT_ESTIMATE.getKey()));
		columns.add(new CaseDialogButton(dueButton, FogBugzAttribute.DUE_DATE
				.getKey()));
		columns.add(new CaseDialogButton(priorityButton,
				FogBugzAttribute.PRIORITY.getKey()));
		columns.add(new CaseDialogButton(projectButton,
				FogBugzAttribute.PROJECT.getKey()));
		columns.add(new CaseDialogButton(areaButton, FogBugzAttribute.AREA
				.getKey()));
		columns.add(new CaseDialogButton(fixForButton, FogBugzAttribute.FIXFOR
				.getKey()));
		columns.add(new CaseDialogButton(categoryButton,
				FogBugzAttribute.CATEGORY.getKey()));
		columns.add(new CaseDialogButton(computerButton,
				FogBugzAttribute.COMPUTER.getKey()));
		columns.add(new CaseDialogButton(versionButton,
				FogBugzAttribute.VERSION.getKey()));
		columns.add(new CaseDialogButton(assignedToButton,
				FogBugzAttribute.ASSIGNED_TO.getKey()));
		columns.add(new CaseDialogButton(openedByButton,
				FogBugzAttribute.OPENED_BY.getKey()));
		columns.add(new CaseDialogButton(openedOnButton,
				FogBugzAttribute.DT_OPENED.getKey()));
		columns.add(new CaseDialogButton(lastUpdatedOnButton,
				FogBugzAttribute.DT_LAST_UPDATED.getKey()));
		columns
				.add(new CaseDialogButton(ccButton, FogBugzAttribute.CC
						.getKey()));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);

		final Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4,
				1));

		selectAllButton = new Button(group, SWT.NONE);
		selectAllButton.setSelection(true);
		selectAllButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				deselectAllButton.setSelection(false);
				selectAllButtons();
			}
		});
		selectAllButton.setLayoutData(new GridData());
		selectAllButton.setText("Select All");

		deselectAllButton = new Button(group, SWT.NONE);
		deselectAllButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectAllButton.setSelection(false);
				deselectAllButtons();
			}
		});
		deselectAllButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		deselectAllButton.setText("Deselect All");

		final Label saveToLocationLabel = new Label(container, SWT.NONE);
		saveToLocationLabel.setText("Save to location:");

		fileName = new Text(container, SWT.BORDER);
		fileName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button browseButton = new Button(container, SWT.NONE);
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(parent.getShell(), SWT.SAVE);
				dialog
						.setFilterExtensions(new String[] { "*."
								+ fileExtension });
				fileName.setText(dialog.open());
			}
		});
		browseButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false));
		browseButton.setText("Browse...");
		setMessage("Provide the columns for the report and the location where it needs to be saved.");
		//
		return area;
	}

	protected void selectAllButtons() {
		for (CaseDialogButton caseButton : columns) {
			caseButton.button.setSelection(true);
		}

	}

	protected void deselectAllButtons() {
		for (CaseDialogButton caseButton : columns) {
			caseButton.button.setSelection(false);
		}

	}

	/**
	 * Create contents of the button bar
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(500, 375);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Case Report Input");
	}

	@Override
	protected void okPressed() {
		fileLocation = fileName.getText();
		if (fileLocation == null || fileLocation.equals("")) {
			this.setErrorMessage("Select a valid file location.");
			return;
		}
		for (CaseDialogButton caseButton : columns) {
			if (caseButton.button.getSelection())
				selectedAttributes.add(caseButton.ID);
		}
		super.okPressed();
	}

	class CaseDialogButton {
		public String ID;

		public Button button;

		public CaseDialogButton(Button button, String ID) {
			this.button = button;
			this.ID = ID;
		}
	}

	public ArrayList<String> getSelectedAttributes() {
		return selectedAttributes;
	}

}
