package com.bugclipse.fogbugz.ui.dialog;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.mylyn.tasks.ui.DatePicker;
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

public class TimesheetParametersDialog extends TitleAreaDialog {

	private Text fileName;

	private DatePicker from;

	private DatePicker to;

	private Date fromDate, toDate;

	private String fileLocation;

	String fileExtension;

	/**
	 * Create the dialog
	 * 
	 * @param parentShell
	 */
	public TimesheetParametersDialog(Shell parentShell, String format) {
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
		container.setLayout(new GridLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		Calendar now = Calendar.getInstance();
		Calendar onemonthbefore = Calendar.getInstance();
		onemonthbefore.add(Calendar.MONTH, -1);

		final Group group = new Group(container, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		group.setLayout(gridLayout);

		final Group group_1 = new Group(group, SWT.NONE);
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				4, 1));
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 3;
		group_1.setLayout(gridLayout_1);

		final Label fromLabel = new Label(group_1, SWT.NONE);
		fromLabel.setText("FROM : ");
		from = new DatePicker(group_1, SWT.BORDER, onemonthbefore.getTime()
				.toString());
		from.setDate(onemonthbefore);
		from.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2,
				1));

		final Label label_1 = new Label(group_1, SWT.NONE);
		label_1.setText("TO: ");

		to = new DatePicker(group_1, SWT.BORDER, now.toString());
		to.setDate(now);
		to
				.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
						2, 1));

		final Label saveToLocationLabel = new Label(group, SWT.NONE);
		saveToLocationLabel.setText("Save to location:");

		fileName = new Text(group, SWT.BORDER);
		fileName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button browseButton = new Button(group, SWT.NONE);
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
		setMessage("Provide the time range for the timesheet and the location where it needs to be stored");
		return area;
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
		newShell.setText("Timesheet Input");
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	@Override
	protected void okPressed() {
		fromDate = from.getDate().getTime();
		toDate = to.getDate().getTime();
		fileLocation = fileName.getText();
		if (fileLocation == null || fileLocation.equals("")) {
			this.setErrorMessage("Select a valid file location.");
			return;
		}
		if (fromDate.after(toDate)) {
			this
					.setErrorMessage("Select valid time ranges. \'From:\' should precede \'To:\'");
			return;
		}
		super.okPressed();

	}
}
