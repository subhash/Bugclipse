package com.bugclipse.fogbugz.api.client;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.mylyn.internal.tasks.core.ScheduledTaskContainer;
import org.eclipse.mylyn.tasks.core.AbstractTask;
import org.eclipse.mylyn.tasks.core.ITaskActivityListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.bugclipse.fogbugz.api.exception.FogBugzAPIException;
import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.core.FogBugzTask;

public class FogBugzTaskActivityManager implements ITaskActivityListener {

	private FogBugzClientManager manager;

	public FogBugzTaskActivityManager(FogBugzClientManager manager) {
		this.manager = manager;
	}

	public void activityChanged(ScheduledTaskContainer container) {

	}

	public void taskActivated(AbstractTask task) {
		if (task instanceof FogBugzTask) {
			final FogBugzTask ft = (FogBugzTask) task;
			final FogBugzClient client = manager.getClient(ft
					.getRepositoryUrl());
			try {
				PlatformUI.getWorkbench().getProgressService().busyCursorWhile(
						new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor)
									throws InvocationTargetException,
									InterruptedException {
								monitor.beginTask("Starting task "
										+ ft.getTaskId(), monitor.UNKNOWN);
								startWork(ft, client, monitor);
							}
						});
			} catch (InvocationTargetException ie) {
				Throwable t = ie.getTargetException();
				if (t instanceof FogBugzAPIException) {
					FogBugzAPIException e = (FogBugzAPIException) t;
					if (e.getError().getCode() == 7) {
						String title = "Cannot start task in repository";
						String message = "This task's start time cannot be tracked because: "
								+ e.getError().getContent();
						MessageDialog.openError(Display.getDefault()
								.getActiveShell(), title, message);
					} else
						MessageDialog.openError(Display.getCurrent()
								.getActiveShell(),
								"Internal error while starting task", e
										.getMessage());
					return;
				}
				if (t instanceof FogBugzClientException) {
					FogBugzClientException e = (FogBugzClientException) t;
					MessageDialog.openError(Display.getDefault()
							.getActiveShell(),
							"Internal error while starting task", e
									.getMessage());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void taskDeactivated(AbstractTask task) {
		if (task instanceof FogBugzTask) {
			final FogBugzTask ft = (FogBugzTask) task;
			final FogBugzClient client = manager.getClient(ft
					.getRepositoryUrl());
			try {
				PlatformUI.getWorkbench().getProgressService().busyCursorWhile(
						new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor)
									throws InvocationTargetException,
									InterruptedException {
								monitor.beginTask("Stopping task "
										+ ft.getTaskId(), monitor.UNKNOWN);
								stopWork(client, monitor);
							}
						});
			} catch (InvocationTargetException ie) {
				Throwable t = ie.getTargetException();
				if (t instanceof FogBugzAPIException) {
					FogBugzAPIException e = (FogBugzAPIException) t;
					if (e.getError().getCode() == 7) {
						String title = "Cannot stop task in repository";
						String message = "This task's stop time cannot be tracked because: "
								+ e.getError().getContent();
						MessageDialog.openError(Display.getDefault()
								.getActiveShell(), title, message);
					} else
						MessageDialog.openError(Display.getDefault()
								.getActiveShell(),
								"Internal error while stopping task", e
										.getMessage());
					return;
				}
				if (t instanceof FogBugzClientException) {
					FogBugzClientException e = (FogBugzClientException) t;
					MessageDialog.openError(Display.getDefault()
							.getActiveShell(),
							"Internal error while stopping task", e
									.getMessage());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void taskListRead() {
	}

	private static void startWork(final FogBugzTask ft,
			final FogBugzClient client, IProgressMonitor monitor)
			throws InvocationTargetException {
		try {
			client.startWork(ft.getTaskId() + "", monitor);
		} catch (FogBugzClientException e) {
			throw new InvocationTargetException(e);
		}
	}

	private static void stopWork(final FogBugzClient client,
			IProgressMonitor monitor) throws InvocationTargetException {
		try {
			client.stopWork(monitor);
		} catch (FogBugzClientException e) {
			throw new InvocationTargetException(e);
		}
	}

}
