package com.bugclipse.fogbugz.ui.actions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.internal.tasks.core.TaskDataManager;
import org.eclipse.mylyn.internal.tasks.ui.views.TaskListView;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;
import org.eclipse.mylyn.tasks.core.AbstractTask;
import org.eclipse.mylyn.tasks.core.AbstractTaskContainer;
import org.eclipse.mylyn.tasks.core.RepositoryTaskData;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUiPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.bugclipse.fogbugz.api.Interval;
import com.bugclipse.fogbugz.api.client.FogBugzClient;
import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.core.FogBugzAttributeAdapter;
import com.bugclipse.fogbugz.core.FogBugzRepositoryConnector;
import com.bugclipse.fogbugz.core.FogBugzTask;
import com.bugclipse.fogbugz.core.IFogBugzConstants.ReportFormat;
import com.bugclipse.fogbugz.core.IFogBugzConstants.ReportType;
import com.bugclipse.fogbugz.reports.ReportLauncher;
import com.bugclipse.fogbugz.ui.FogBugzUiPlugin;
import com.bugclipse.fogbugz.ui.dialog.CaseReportParametersDialog;
import com.bugclipse.fogbugz.ui.dialog.TimesheetParametersDialog;

public class RunReportAction extends Action {

	ReportFormat format;

	ReportType reportType = ReportType.TIMESHEET;

	public RunReportAction(ReportType reportType, ReportFormat format) {
		super();
		this.setText(format.getLabel());
		this.format = format;
		this.reportType = reportType;
	}

	@Override
	public void run() {
		ILog log = FogBugzUiPlugin.getDefault().getLog();
		if (TaskListView.getFromActivePerspective() != null) {
			ISelection selection = TaskListView.getFromActivePerspective()
					.getViewer().getSelection();
			if (reportType.equals(ReportType.TIMESHEET))
				try {
					runTimesheetReport(selection);
				} catch (FogBugzClientException e) {
					log.log(new Status(Status.ERROR, FogBugzUiPlugin
							.getDefault().getBundle().getSymbolicName(), 1,
							"Exception while generating timesheet report", e));
					MessageDialog.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(),
							"Error while generating timesheet report", e
									.getMessage());
				}
			if (reportType.equals(ReportType.CASE_REPORT)) {
				try {
					runCaselistReport(selection);
				} catch (FogBugzClientException e) {
					log.log(new Status(Status.ERROR, FogBugzUiPlugin
							.getDefault().getBundle().getSymbolicName(), 2,
							"Exception while generating case report", e));
					MessageDialog.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(),
							"Error while generating case list report", e
									.getMessage());
				}
			}
		}
	}

	private void runTimesheetReport(ISelection selection)
			throws FogBugzClientException {
		String repo = "", repoUrl = "";
		for (Object obj : ((IStructuredSelection) selection).toList()) {
			if (obj instanceof AbstractRepositoryQuery) {
				AbstractRepositoryQuery q = (AbstractRepositoryQuery) obj;
				repo = q.getRepositoryKind();
				repoUrl = q.getRepositoryUrl();
				break;
			}
			if (obj instanceof AbstractTask) {
				AbstractTask t = (AbstractTask) obj;
				repo = t.getConnectorKind();
				repoUrl = t.getRepositoryUrl();
				break;
			}
			if (obj instanceof AbstractTaskContainer) {
				AbstractTaskContainer c = (AbstractTaskContainer) obj;
				for (AbstractTask t : c.getChildren()) {
					repo = t.getConnectorKind();
					repoUrl = t.getRepositoryUrl();
					break;
				}
			}
		}
		if (!repo.equals("")) {
			TimesheetParametersDialog parametersDialog = new TimesheetParametersDialog(
					Display.getDefault().getActiveShell(), format
							.getFileExtension());
			if (parametersDialog.open() == Dialog.CANCEL)
				return;
			final String from = FogBugzAttributeAdapter
					.toUTCFormat(parametersDialog.getFromDate());
			final String to = FogBugzAttributeAdapter
					.toUTCFormat(parametersDialog.getToDate());

			final String filename = parametersDialog.getFileLocation();

			FogBugzRepositoryConnector conn = (FogBugzRepositoryConnector) TasksUiPlugin
					.getRepositoryManager().getRepositoryConnector(repo);
			final FogBugzClient client = conn.getClientManager()
					.getClient(
							TasksUiPlugin.getRepositoryManager().getRepository(
									repoUrl));

			try {
				ProgressMonitorDialog dialog = new ProgressMonitorDialog(null);
				dialog.run(true, true, new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {
						try {
							monitor.beginTask("Retrieving intervals",
									IProgressMonitor.UNKNOWN);
							Map<String, Object> scriptable = new HashMap<String, Object>();
							Interval[] in = client.getIntervals(from, to,
									monitor);
							scriptable.put("Intervals", in);
							monitor.worked(1);
							if (monitor.isCanceled())
								return;

							monitor.beginTask("Generating the report",
									IProgressMonitor.UNKNOWN);
							ReportLauncher.runReport(scriptable, reportType
									.getReportFileName(), filename, format
									.getBirtConstant(), monitor);
							monitor.worked(1);
							if (monitor.isCanceled())
								return;

						} catch (FogBugzClientException e) {
							monitor.setCanceled(true);
							throw new InvocationTargetException(e);
						} finally {
							monitor.done();
						}
					}
				});
				if (!dialog.getProgressMonitor().isCanceled()) {
					try {
						PlatformUI.getWorkbench().getBrowserSupport()
								.createBrowser("Timesheet").openURL(
										new File(filename).toURL());
					} catch (PartInitException e) {
						throw new FogBugzClientException(
								"Report generated but cannot be displayed: "
										+ e.getMessage(), e);
					} catch (MalformedURLException e) {
						throw new FogBugzClientException(
								"Internal error in displaying report. Defective URL: "
										+ e.getMessage(), e);
					}
				}
			} catch (InvocationTargetException e1) {
				if (e1.getCause() instanceof FogBugzClientException)
					throw (FogBugzClientException) e1.getCause();
				else
					throw new FogBugzClientException(
							"Could not invoke report generation "
									+ e1.getMessage(), e1);
			} catch (InterruptedException e1) {
				throw new FogBugzClientException(
						"Report generation was interrupted " + e1.getMessage(),
						e1);
			}
		}
	}

	private void runCaselistReport(ISelection selection)
			throws FogBugzClientException {
		final ArrayList<FogBugzTask> tasks = new ArrayList<FogBugzTask>();
		for (Object obj : ((IStructuredSelection) selection).toList()) {
			if (obj instanceof FogBugzTask) {
				FogBugzTask ft = (FogBugzTask) obj;
				tasks.add(ft);
			}
			if (obj instanceof AbstractRepositoryQuery) {
				AbstractRepositoryQuery q = (AbstractRepositoryQuery) obj;
				for (AbstractTask task : q.getChildren()) {
					if (task instanceof FogBugzTask) {
						FogBugzTask f = (FogBugzTask) task;
						tasks.add(f);
					}
				}
			}
		}
		CaseReportParametersDialog parametersDialog = new CaseReportParametersDialog(
				Display.getDefault().getActiveShell(), format
						.getFileExtension());
		if (parametersDialog.open() == Dialog.CANCEL)
			return;
		final String filename = parametersDialog.getFileLocation();
		final ArrayList<String> showAttributes = parametersDialog
				.getSelectedAttributes();
		final ArrayList<RepositoryTaskData> taskData = new ArrayList<RepositoryTaskData>();
		final ProgressMonitorDialog dialog = new ProgressMonitorDialog(null);
		try {
			dialog.run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					TaskDataManager tm = TasksUiPlugin.getTaskDataManager();
					monitor.beginTask("Extracting task information",
							monitor.UNKNOWN);
					for (FogBugzTask task : tasks) {
						if (monitor.isCanceled())
							return;
						else
							monitor.worked(1);
						RepositoryTaskData newTaskData = tm.getNewTaskData(task
								.getRepositoryUrl(), task.getTaskId());
						if (newTaskData == null) {
							monitor
									.setTaskName("Fetching task information from repository for task "
											+ task.getTaskId());
							AbstractRepositoryConnector conn = TasksUiPlugin
									.getRepositoryManager()
									.getRepositoryConnector(task);
							TaskRepository repository = TasksUiPlugin
									.getRepositoryManager().getRepository(
											task.getRepositoryUrl());
							try {
								RepositoryTaskData rtd = conn
										.getTaskDataHandler().getTaskData(
												repository, task.getTaskId(),
												monitor);
								tm.setNewTaskData(rtd);
								taskData.add(rtd);
							} catch (CoreException e) {
								throw new InvocationTargetException(e);
							}
						} else {
							taskData.add(newTaskData);
						}
					}
					monitor.beginTask("Generating report", monitor.UNKNOWN);
					Map<String, Object> scriptable = new HashMap<String, Object>();
					scriptable.put("Tasks", taskData
							.toArray(new RepositoryTaskData[0]));
					scriptable.put("ShowAttributes", showAttributes);
					try {
						ReportLauncher.runReport(scriptable, reportType
								.getReportFileName(), filename, format
								.getBirtConstant(), new NullProgressMonitor());
					} catch (FogBugzClientException e) {
						monitor.setCanceled(true);
						throw new InvocationTargetException(e);
					} finally {
						monitor.done();
					}
				}
			});

			try {
				if (!dialog.getProgressMonitor().isCanceled())
					PlatformUI.getWorkbench().getBrowserSupport()
							.createBrowser("Case List").openURL(
									new File(filename).toURL());
			} catch (PartInitException e) {
				throw new FogBugzClientException(
						"Report generated but cannot be displayed: "
								+ e.getMessage(), e);
			} catch (MalformedURLException e) {
				throw new FogBugzClientException(
						"Internal error in displaying report. Defective URL: "
								+ e.getMessage(), e);
			}
		} catch (InvocationTargetException e1) {
			if (e1.getCause() instanceof FogBugzClientException)
				throw (FogBugzClientException) e1.getCause();
			if (e1.getCause() instanceof CoreException)
				throw new FogBugzClientException(
						"Communication with repository failed: "
								+ e1.getCause().getMessage(), e1.getCause());
			throw new FogBugzClientException(
					"Could not invoke report generation " + e1.getMessage(), e1);
		} catch (InterruptedException e1) {
			throw new FogBugzClientException(
					"Report generation was interrupted " + e1.getMessage(), e1);
		}

	}
}
