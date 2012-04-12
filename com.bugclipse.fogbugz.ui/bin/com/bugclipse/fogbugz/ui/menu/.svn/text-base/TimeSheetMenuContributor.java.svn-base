package com.bugclipse.fogbugz.ui.menu;

import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.mylyn.internal.tasks.ui.IDynamicSubMenuContributor;
import org.eclipse.mylyn.tasks.core.AbstractTaskContainer;

import com.bugclipse.fogbugz.core.FogBugzRepositoryQuery;
import com.bugclipse.fogbugz.core.FogBugzTask;
import com.bugclipse.fogbugz.core.IFogBugzConstants.ReportFormat;
import com.bugclipse.fogbugz.core.IFogBugzConstants.ReportType;
import com.bugclipse.fogbugz.ui.actions.RunReportAction;

public class TimeSheetMenuContributor implements IDynamicSubMenuContributor {

	private static String LABEL_TIMESHEET = "Timesheet";

	private static ReportType type = ReportType.TIMESHEET;

	public MenuManager getSubMenuManager(
			List<AbstractTaskContainer> selectedElements) {
		for (AbstractTaskContainer container : selectedElements) {
			if (!(container instanceof FogBugzTask)
					&& !(container instanceof FogBugzRepositoryQuery))
				return null;
		}
		final MenuManager subMenuManager = new MenuManager(LABEL_TIMESHEET);
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
