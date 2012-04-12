package com.bugclipse.fogbugz.ui.editor;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.mylyn.internal.tasks.ui.TaskListColorsAndFonts;
import org.eclipse.mylyn.internal.tasks.ui.TasksUiImages;
import org.eclipse.mylyn.tasks.core.RepositoryTaskAttribute;
import org.eclipse.mylyn.tasks.ui.DatePicker;
import org.eclipse.mylyn.tasks.ui.editors.AbstractNewRepositoryTaskEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.themes.IThemeManager;

import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.core.FogBugzAttributeFactory;
import com.bugclipse.fogbugz.core.FogBugzConstants;
import com.bugclipse.fogbugz.core.FogBugzAttributeFactory.FogBugzAttribute;

public class NewFogbugzTaskEditor extends AbstractNewRepositoryTaskEditor {

	FormToolkit toolkit;

	private Color colorIncoming;

	private CCombo areaCombo;

	private CCombo fixForCombo;

	protected Text origEstimateText;

	protected Text deadlineText;

	protected DatePicker deadlinePicker;

	public NewFogbugzTaskEditor(FormEditor editor) {
		super(editor);
	}

	protected void createFormContent(IManagedForm form) {
		this.toolkit = form.getToolkit();
		IThemeManager themeManager = getSite().getWorkbenchWindow()
				.getWorkbench().getThemeManager();
		colorIncoming = themeManager.getCurrentTheme().getColorRegistry().get(
				TaskListColorsAndFonts.THEME_COLOR_TASKS_INCOMING_BACKGROUND);
		super.createFormContent(form);
	}

	@Override
	protected void createAttributeLayout(Composite attributesComposite) {
		int numColumns = ((GridLayout) attributesComposite.getLayout()).numColumns;
		int currentCol = 1;

		for (final RepositoryTaskAttribute attribute : taskData.getAttributes()) {
			if (attribute.isHidden()) {
				continue;
			}

			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
			data.horizontalSpan = 1;
			if ((attribute.hasOptions()
					|| attribute.getId().equals(FogBugzAttribute.AREA.getKey()) || attribute
					.getId().equals(FogBugzAttribute.FIXFOR.getKey()))
					&& !attribute.isReadOnly()) {
				Label label = createLabel(attributesComposite, attribute);
				GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.CENTER)
						.applyTo(label);
				final CCombo attributeCombo = new CCombo(attributesComposite,
						SWT.FLAT | SWT.READ_ONLY);
				toolkit.adapt(attributeCombo, true, true);
				attributeCombo.setFont(TEXT_FONT);
				attributeCombo.setData(FormToolkit.KEY_DRAW_BORDER,
						FormToolkit.TEXT_BORDER);
				if (hasChanged(attribute)) {
					attributeCombo.setBackground(colorIncoming);
				}
				attributeCombo.setLayoutData(data);
				List<String> values = null;

				if (attribute.getId().equals(FogBugzAttribute.AREA.getKey())) {
					values = getAreas();
				} else if (attribute.getId().equals(
						FogBugzAttribute.FIXFOR.getKey())) {
					values = attribute.getOptions();
				} else
					values = attribute.getOptions();
				if (attribute.getId()
						.equals(FogBugzAttribute.PRIORITY.getKey())) {
					String[] valueArray = values.toArray(new String[0]);
					Arrays.sort(valueArray, new Comparator<String>() {
						public int compare(String s1, String s2) {
							return s1.compareTo(s2);
						}

					});
					values = Arrays.asList(valueArray);
				}

				if (values != null) {
					for (String val : values) {
						if (val != null) {
							attributeCombo.add(val);
						}
					}
				}

				String value = attribute.getValue();
				if (value == null) {
					value = "";
				}
				if (attributeCombo.indexOf(value) != -1) {
					attributeCombo.select(attributeCombo.indexOf(value));
				}
				attributeCombo.clearSelection();
				attributeCombo.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent event) {
						if (attributeCombo.getSelectionIndex() > -1) {
							String sel = attributeCombo.getItem(attributeCombo
									.getSelectionIndex());
							if (attribute.hasOptions())
								attribute.setValue(attribute
										.getOptionParameter(sel));
							else
								attribute.setValue(sel);
							attributeChanged(attribute);
							attributeCombo.clearSelection();
							if (attribute.getId().equals(
									FogBugzAttribute.PROJECT.getKey())) {
								refreshAreaCombo(attribute);
								refreshFixForCombo(attribute);
							}
						}
					}
				});
				if (attribute.getId().equals(FogBugzAttribute.AREA.getKey())) {
					areaCombo = attributeCombo;
				} else if (attribute.getId().equals(
						FogBugzAttribute.FIXFOR.getKey())) {
					fixForCombo = attributeCombo;
				}
				currentCol += 2;
			} else {
				Label label = createLabel(attributesComposite, attribute);
				GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.CENTER)
						.applyTo(label);
				Composite textFieldComposite = toolkit
						.createComposite(attributesComposite);
				GridLayout textLayout = new GridLayout();
				textLayout.marginWidth = 1;
				textLayout.marginHeight = 2;
				textFieldComposite.setLayout(textLayout);
				GridData textData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
				textData.horizontalSpan = 1;
				textData.widthHint = 135;

				if (attribute.isReadOnly()) {
					final Text text = createTextField(textFieldComposite,
							attribute, SWT.FLAT | SWT.READ_ONLY);
					text.setLayoutData(textData);
				} else {
					final Text text = createTextField(textFieldComposite,
							attribute, SWT.FLAT);
					// text.setFont(COMMENT_FONT);
					text.setLayoutData(textData);
					toolkit.paintBordersFor(textFieldComposite);
					text.setData(attribute);

					if (hasContentAssist(attribute)) {
						ContentAssistCommandAdapter adapter = applyContentAssist(
								text, createContentProposalProvider(attribute));

						ILabelProvider propsalLabelProvider = createProposalLabelProvider(attribute);
						if (propsalLabelProvider != null) {
							adapter.setLabelProvider(propsalLabelProvider);
						}
						adapter
								.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
					}
				}

				currentCol += 2;
			}

			if (currentCol > numColumns) {
				currentCol -= numColumns;
			}
		}

		// make sure that we are in the first column
		if (currentCol > 1) {
			while (currentCol <= numColumns) {
				toolkit.createLabel(attributesComposite, "");
				currentCol++;
			}
		}

		toolkit.paintBordersFor(attributesComposite);
	}

	@Override
	protected void createCustomAttributeLayout(Composite composite) {
		super.createCustomAttributeLayout(composite);
		addFogBugzTimeTracker(getManagedForm().getToolkit(), composite);
	}

	private List<String> getAreas() {
		String project = taskData.getAttributeValue(FogBugzAttribute.PROJECT
				.getKey());
		String areaOptionsId = project + FogBugzAttributeFactory.filler
				+ FogBugzAttribute.AREA.getKey();
		return taskData.getAttribute(areaOptionsId).getOptions();

	}

	/**
	 * @return The hidden attribute which holds fixfor options for current
	 *         project
	 * @throws FogBugzClientException
	 */
	private RepositoryTaskAttribute getFixForOptionAttr() {
		String project = taskData.getAttributeValue(FogBugzAttribute.PROJECT
				.getKey());
		String fixForOptionsId = project + FogBugzAttributeFactory.filler
				+ FogBugzAttribute.FIXFOR.getKey();
		return taskData.getAttribute(fixForOptionsId);

	}

	private void refreshFixForCombo(RepositoryTaskAttribute projectAttribute) {
		if (projectAttribute.getValue() != null) {
			RepositoryTaskAttribute fixForAttribute = taskData
					.getAttribute(FogBugzAttribute.FIXFOR.getKey());
			String oldFixFor = fixForAttribute.getValue();
			List<String> sFix = null;
			RepositoryTaskAttribute optionAttr = getFixForOptionAttr();
			sFix = optionAttr.getOptions();

			if (sFix != null) {
				fixForCombo.removeAll();
				fixForCombo.clearSelection();
				fixForAttribute.clearOptions();
				boolean setValue = false;
				for (String value : sFix) {
					if (value != null) {
						fixForCombo.add(value);
						String param = optionAttr.getOptionParameter(value);
						fixForAttribute.addOption(value, param);
						if (param.equals(oldFixFor)) {
							fixForAttribute.setValue(value);
							setValue = true;
						}
					}
				}
				if (!setValue)
					fixForAttribute.setValue(sFix.get(0));
				String value = fixForAttribute.getValue();
				if (value == null) {
					value = "";
				}
				if (fixForCombo.indexOf(value) != -1) {
					fixForCombo.select(fixForCombo.indexOf(value));
				}
				attributeChanged(fixForAttribute);
			}
		}

	}

	private void refreshAreaCombo(RepositoryTaskAttribute projectAttribute) {
		if (projectAttribute.getValue() != null) {
			RepositoryTaskAttribute areaAttribute = taskData
					.getAttribute(FogBugzAttribute.AREA.getKey());
			String oldArea = areaAttribute.getValue();
			List<String> sAreas = getAreas();
			if (sAreas != null) {
				areaCombo.removeAll();
				areaCombo.clearSelection();
				boolean setValue = false;
				for (String value : sAreas) {
					if (value != null) {
						areaCombo.add(value);
						if (value.equals(oldArea)) {
							areaAttribute.setValue(value);
							setValue = true;
						}
					}
				}
				if (!setValue)
					areaAttribute.setValue(sAreas.get(0));
				String value = areaAttribute.getValue();
				if (value == null) {
					value = "";
				}
				if (areaCombo.indexOf(value) != -1) {
					areaCombo.select(areaCombo.indexOf(value));
				}
				attributeChanged(areaAttribute);
			}
		}

	}

	protected void addFogBugzTimeTracker(FormToolkit toolkit, Composite parent) {

		Section timeSection = toolkit.createSection(parent,
				ExpandableComposite.SHORT_TITLE_BAR);
		timeSection.setText(FogBugzConstants.LABEL_TIME_TRACKING);
		GridLayout gl = new GridLayout();
		GridData gd = new GridData(SWT.FILL, SWT.NONE, false, false);
		gd.horizontalSpan = 4;
		timeSection.setLayout(gl);
		timeSection.setLayoutData(gd);

		Composite timeComposite = toolkit.createComposite(timeSection);
		gl = new GridLayout(4, false);
		timeComposite.setLayout(gl);
		gd = new GridData();
		gd.horizontalSpan = 5;
		timeComposite.setLayoutData(gd);

		RepositoryTaskAttribute attribute = this.taskData
				.getAttribute(FogBugzAttribute.ORIGINAL_ESTIMATE.getKey());
		if (attribute != null && attribute.isReadOnly()) {
			String value = attribute.getValue();
			if (value != null && !value.equals("")) {
				createLabel(timeComposite, attribute);
				origEstimateText = createTextField(timeComposite, attribute,
						SWT.FLAT);
				origEstimateText.setLayoutData(new GridData(
						GridData.HORIZONTAL_ALIGN_FILL));
				origEstimateText.setEditable(false);
				origEstimateText.setText(value);
			}
		}

		attribute = this.taskData
				.getAttribute(FogBugzAttribute.CURRENT_ESTIMATE.getKey());
		Label label = createLabel(timeComposite, attribute);
		// label.setForeground(toolkit.getColors().getColor(IFormColors.TITLE));

		Text currentEstimate = createTextField(timeComposite, attribute,
				SWT.FLAT);
		currentEstimate.setFont(TEXT_FONT);
		currentEstimate.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL));
		currentEstimate.setEditable(true);

		attribute = this.taskData.getAttribute(FogBugzAttribute.HRS_ELAPSED
				.getKey());
		if (attribute != null) {
			createLabel(timeComposite, attribute);
			Text elapsedText = createTextField(timeComposite, attribute,
					SWT.FLAT);
			elapsedText.setLayoutData(new GridData(
					GridData.HORIZONTAL_ALIGN_FILL));
			elapsedText.setEditable(false);
			elapsedText.setText(attribute.getValue());
		}

		attribute = this.taskData.getAttribute(FogBugzAttribute.DUE_DATE
				.getKey());
		createLabel(timeComposite, attribute);

		Composite dateWithClear = toolkit.createComposite(timeComposite);
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 1;
		dateWithClear.setLayout(layout);

		String dateString = taskData
				.getAttributeValue(FogBugzAttribute.DUE_DATE.getKey());
		deadlinePicker = new DatePicker(dateWithClear, SWT.BORDER, dateString);
		deadlinePicker.setFont(TEXT_FONT);
		deadlinePicker.setDatePattern(FogBugzConstants.DATE_PATTERN);
		if (hasChanged(attribute)) {
			deadlinePicker.setBackground(getColorIncoming());
		}
		deadlinePicker.addPickerSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// ignore
			}

			public void widgetSelected(SelectionEvent e) {
				Calendar cal = deadlinePicker.getDate();
				if (cal != null) {
					SimpleDateFormat f = new SimpleDateFormat(
							FogBugzConstants.DATE_PATTERN);
					taskData.setAttributeValue(FogBugzAttribute.DUE_DATE
							.getKey(), f.format(cal.getTime()));
					attributeChanged(taskData
							.getAttribute(FogBugzAttribute.DUE_DATE.getKey()));
					// TODO goes dirty even if user presses cancel
					// markDirty(true);
				} else {
					taskData.setAttributeValue(FogBugzAttribute.DUE_DATE
							.getKey(), "");
					attributeChanged(taskData
							.getAttribute(FogBugzAttribute.DUE_DATE.getKey()));
					deadlinePicker.setDate(null);
				}
			}
		});

		ImageHyperlink clearDeadlineDate = toolkit.createImageHyperlink(
				dateWithClear, SWT.NONE);
		clearDeadlineDate
				.setImage(TasksUiImages.getImage(TasksUiImages.REMOVE));
		clearDeadlineDate.setToolTipText("Clear");
		clearDeadlineDate.addHyperlinkListener(new HyperlinkAdapter() {

			@Override
			public void linkActivated(HyperlinkEvent e) {
				taskData.setAttributeValue(FogBugzAttribute.DUE_DATE.getKey(),
						"");
				attributeChanged(taskData
						.getAttribute(FogBugzAttribute.DUE_DATE.getKey()));
				deadlinePicker.setDate(null);
			}
		});

		timeSection.setClient(timeComposite);
	}
}
