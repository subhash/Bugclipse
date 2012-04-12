package com.bugclipse.fogbugz.ui.menu;

import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.mylyn.internal.tasks.ui.IDynamicSubMenuContributor;
import org.eclipse.mylyn.tasks.core.AbstractTaskContainer;

import com.bugclipse.fogbugz.core.IFogBugzConstants.ReportFormat;
import com.bugclipse.fogbugz.core.IFogBugzConstants.ReportType;
import com.bugclipse.fogbugz.ui.actions.RunReportAction;

public class CaseReportMenuContributor implements IDynamicSubMenuContributor {

	private static String LABEL_CASEREPORT = "Case Report";

	private static ReportType type = ReportType.CASE_REPORT;

	public MenuManager getSubMenuManager(
			List<AbstractTaskContainer> selectedElements) {
		final MenuManager subMenuManager = new MenuManager(LABEL_CASEREPORT);
		subMenuManager.setVisible(selectedElements.size() > 0);
		RunReportAction actionHtml = new RunReportAction(type,
				ReportFormat.HTML);
		subMenuManager.add(actionHtml);
		RunReportAction actionPdf = new RunReportAction(type, ReportFormat.PDF);
		subMenuManager.add(actionPdf);
		RunReportAction actionExcel = new RunReportAction(type,
				ReportFormat.EXCEL);
		subMenuManager.add(actionExcel);
		RunReportAction actionPostScript = new RunReportAction(type,
				ReportFormat.POSTSCRIPT);
		subMenuManager.add(actionPostScript);
		return subMenuManager;
	}

}
