package com.bugclipse.fogbugz.core;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.mylyn.tasks.core.AbstractAttachmentHandler;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;
import org.eclipse.mylyn.tasks.core.AbstractTask;
import org.eclipse.mylyn.tasks.core.AbstractTaskDataHandler;
import org.eclipse.mylyn.tasks.core.ITaskCollector;
import org.eclipse.mylyn.tasks.core.RepositoryTaskData;
import org.eclipse.mylyn.tasks.core.TaskList;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUiPlugin;
import org.eclipse.swt.widgets.Display;

import com.bugclipse.fogbugz.api.Case;
import com.bugclipse.fogbugz.api.client.FogBugzClient;
import com.bugclipse.fogbugz.api.client.FogBugzClientManager;
import com.bugclipse.fogbugz.api.client.FogBugzTaskActivityManager;
import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.api.exception.FogBugzStatus;
import com.bugclipse.fogbugz.core.FogBugzAttributeFactory.FogBugzAttribute;
import com.bugclipse.fogbugz.model.FogBugzFilter;

public class FogBugzRepositoryConnector extends AbstractRepositoryConnector {

	private static final String LABEL = "FogBugz Repository";

	private FogBugzClientManager clientManager;

	private FogBugzTaskDataHandler taskDataHandler = new FogBugzTaskDataHandler(
			this);

	private FogBugzAttachmentHandler attachmentHandler = new FogBugzAttachmentHandler(
			this);

	@Override
	public void init(TaskList taskList) {
		super.init(taskList);
		FogBugzTaskActivityManager taskManager = new FogBugzTaskActivityManager(
				getClientManager());
		TasksUiPlugin.getTaskListManager().addActivityListener(taskManager);
	}

	@Override
	public String getLabel() {
		return LABEL;
	}

	@Override
	public String getConnectorKind() {
		return FogBugzCorePlugin.REPOSITORY_KIND;
	}

	@Override
	public IStatus performQuery(AbstractRepositoryQuery query,
			TaskRepository repository, IProgressMonitor monitor,
			ITaskCollector resultCollector) {
		if (query instanceof FogBugzRepositoryQuery) {
			FogBugzRepositoryQuery q = (FogBugzRepositoryQuery) query;
			// if (q.getFilter() == null) {

			if (q.getFilterId() == null || q.getFilterId().equals("")) {
				Map<String, String> queryParameters = q.getParams();
				String queryUrl = q.getUrl();
				String queryPattern = q.getQueryPattern();
				String taskPrefix = q.getTaskPrefix();
				queryUrl = WebRepositoryConnector.evaluateParams(queryUrl,
						queryParameters, repository);
				queryPattern = WebRepositoryConnector.evaluateParams(
						queryPattern, queryParameters, repository);
				monitor.beginTask("Fetching tasks ..", 100);
				try {
					String resource = WebRepositoryConnector.fetchResource(
							queryUrl, queryParameters, repository, monitor);
					return performQuery(resource, queryPattern, taskPrefix,
							monitor, resultCollector, repository, taskList);
				} catch (IOException e) {
					return new Status(IStatus.OK, FogBugzCorePlugin.PLUGIN_ID,
							IStatus.OK,
							"Could not fetch resource: " + queryUrl, e);
				} catch (InterruptedException e) {
					return new Status(IStatus.CANCEL,
							FogBugzCorePlugin.PLUGIN_ID, IStatus.CANCEL,
							"Cancelled fetching of tasks: " + queryUrl, e);
				}
			} else {
				String f = q.getFilterId();
				try {
					Case[] cases = getClientManager().getClient(repository)
							.getCasesIn(f, monitor);
					for (int i = 0; i < cases.length; i++) {
						resultCollector.accept(new FogBugzTask(repository
								.getUrl(), cases[i], getClientManager()
								.getClient(repository)));
					}
				} catch (FogBugzClientException e) {
					return FogBugzStatus.createClientErrorStatus(repository, e);
				}
			}
		}
		if (query instanceof FogBugzSearchQuery) {
			FogBugzSearchQuery q = (FogBugzSearchQuery) query;
			try {
				Case[] cases = getClientManager().getClient(repository).search(
						q.getSearchText(), monitor);
				for (int i = 0; i < cases.length; i++) {
					resultCollector
							.accept(new FogBugzTask(repository.getUrl(),
									cases[i], getClientManager().getClient(
											repository)));
				}
			} catch (FogBugzClientException e) {
				return FogBugzStatus.createClientErrorStatus(repository, e);
			}
		}
		return Status.OK_STATUS;
	}

	public static IStatus performQuery(String resource, String regexp,
			String taskPrefix, IProgressMonitor monitor,
			ITaskCollector collector, TaskRepository repository,
			TaskList taskList) {
		Pattern p = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE
				| Pattern.MULTILINE | Pattern.DOTALL | Pattern.UNICODE_CASE
				| Pattern.CANON_EQ);
		Matcher matcher = p.matcher(resource);

		if (!matcher.find()) {
			Display display = Display.getCurrent();
			if (display == null)
				display = new Display();
			MessageDialog.openInformation(display.getActiveShell(),
					"No cases!", "No cases found for selected filter");
			return Status.OK_STATUS;
		} else {
			boolean isCorrect = true;
			do {
				if (matcher.groupCount() < 2) {
					isCorrect = false;
				}
				if (matcher.groupCount() >= 1) {
					String id = matcher.group(1);
					String description = matcher.groupCount() > 1 ? WebRepositoryConnector
							.cleanup(matcher.group(2), repository)
							: null;
					description = WebRepositoryConnector
							.htmlunescape(description);
					collector.accept(new FogBugzTask(repository.getUrl(), id,
							description));
				}
			} while (matcher.find() && !monitor.isCanceled());

			if (isCorrect) {
				return Status.OK_STATUS;
			} else {
				return new Status(
						IStatus.ERROR,
						FogBugzCorePlugin.PLUGIN_ID,
						IStatus.ERROR,
						"Require two matching groups (taskId and summary). Check query regexp",
						null);
			}
		}
	}

	public static IStatus performFilterQuery(String queryUrl, String regexp,
			TaskRepository repository, List<FogBugzFilter> results,
			IProgressMonitor monitor) throws IOException, InterruptedException {
		Map<String, String> params = new HashMap<String, String>();
		queryUrl = WebRepositoryConnector.evaluateParams(queryUrl, repository);
		String resource = WebRepositoryConnector.fetchResource(queryUrl,
				params, repository, monitor);
		Pattern p = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE
				| Pattern.MULTILINE | Pattern.DOTALL | Pattern.UNICODE_CASE
				| Pattern.CANON_EQ);
		Matcher matcher = p.matcher(resource);

		if (!matcher.find()) {
			return new Status(IStatus.ERROR, FogBugzCorePlugin.PLUGIN_ID,
					IStatus.ERROR,
					"Unable to parse resource. Check query regexp", null);
		} else {
			boolean isCorrect = true;
			do {
				if (matcher.groupCount() < 3) {
					isCorrect = false;
				}
				if (matcher.groupCount() >= 3) {
					String url = repository.getUrl()
							+ FogBugzConstants.URL_FILTERED_CASES
							+ matcher.group(1);
					String name = matcher.groupCount() > 1 ? WebRepositoryConnector
							.cleanup(matcher.group(2), repository)
							: null;
					String description = matcher.groupCount() > 2 ? WebRepositoryConnector
							.cleanup(matcher.group(3), repository)
							: null;
					results.add(new FogBugzFilter(name, description, url));
				}
			} while (matcher.find());
			if (isCorrect) {
				return Status.OK_STATUS;
			} else {
				return new Status(
						IStatus.ERROR,
						FogBugzCorePlugin.PLUGIN_ID,
						IStatus.ERROR,
						"Require two matching groups (taskId and summary). Check query regexp",
						null);
			}
		}
	}

	public static IStatus performDefaultFilterQuery(String queryUrl,
			String regexp, TaskRepository repository,
			List<FogBugzFilter> results, IProgressMonitor monitor)
			throws IOException, InterruptedException {
		Map<String, String> params = new HashMap<String, String>();
		queryUrl = WebRepositoryConnector.evaluateParams(queryUrl, repository);
		String resource = WebRepositoryConnector.fetchResource(queryUrl,
				params, repository, monitor);
		Pattern p = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE
				| Pattern.MULTILINE | Pattern.DOTALL | Pattern.UNICODE_CASE
				| Pattern.CANON_EQ);
		Matcher matcher = p.matcher(resource);

		if (!matcher.find()) {
			return new Status(IStatus.ERROR, FogBugzCorePlugin.PLUGIN_ID,
					IStatus.ERROR,
					"Unable to parse resource. Check query regexp", null);
		} else {
			boolean isCorrect = true;
			if (matcher.groupCount() < 2) {
				isCorrect = false;
			}
			if (matcher.groupCount() >= 2) {
				String url = repository.getUrl() + FogBugzConstants.URL_MYCASES
						+ matcher.group(1);
				String name = matcher.groupCount() > 1 ? WebRepositoryConnector
						.cleanup(matcher.group(2), repository) : null;
				results.add(new FogBugzFilter(name, "", url));
				url = repository.getUrl() + FogBugzConstants.URL_INBOX;
				name = "Inbox";
				results.add(new FogBugzFilter(name, "", url));
			}
			if (isCorrect) {
				return Status.OK_STATUS;
			} else {
				return new Status(
						IStatus.ERROR,
						FogBugzCorePlugin.PLUGIN_ID,
						IStatus.ERROR,
						"Require two matching groups (taskId and summary). Check query regexp",
						null);
			}
		}
	}

	@Override
	public boolean canCreateNewTask(TaskRepository arg0) {
		return true;
	}

	@Override
	public boolean canCreateTaskFromKey(TaskRepository arg0) {
		return true;
	}

	@Override
	public AbstractTask createTask(String repositoryUrl, String id,
			String summary) {
		FogBugzTask fogBugzTask = new FogBugzTask(repositoryUrl, id, summary);
		fogBugzTask.setCreationDate(new Date());
		return fogBugzTask;
	}

	@Override
	public AbstractAttachmentHandler getAttachmentHandler() {
		return attachmentHandler;
	}

	@Override
	public String getRepositoryUrlFromTaskUrl(String url) {
		if (url == null) {
			return null;
		} else {
			int index = url.lastIndexOf(FogBugzConstants.URL_TASK);
			return index == -1 ? null : url.substring(0, index);
		}
	}

	@Override
	public AbstractTaskDataHandler getTaskDataHandler() {
		return taskDataHandler;
	}

	@Override
	public String getTaskIdFromTaskUrl(String url) {
		if (url == null) {
			return null;
		}
		int index = url.indexOf(FogBugzConstants.URL_TASK);
		return index == -1 ? null : url.substring(index
				+ FogBugzConstants.URL_TASK.length());
	}

	@Override
	public String getTaskUrl(String repositoryUrl, String id) {
		return (repositoryUrl + FogBugzConstants.URL_TASK + id);
	}

	@Override
	public boolean markStaleTasks(TaskRepository repository,
			Set<AbstractTask> tasks, IProgressMonitor monitor)
			throws CoreException {
		try {
			monitor
					.beginTask("Getting changed cases",
							IProgressMonitor.UNKNOWN);

			String syncTime = repository.getSynchronizationTimeStamp();
			if (syncTime == null || syncTime.length() == 0) {
				for (AbstractTask task : tasks) {
					task.setStale(true);
				}
				return true;
			}

			try {
				FogBugzClient client = getClientManager().getClient(repository);
				Case[] cases = client.getChangedCases(syncTime);
				Set<String> ids = new HashSet<String>();
				for (int i = 0; i < cases.length; i++) {
					ids.add(cases[i].getIxBug() + "");
				}
				if (ids.isEmpty())
					return false;
				if (ids.size() == 1) {
					String id = ids.iterator().next();
					Case c = client.getCaseUpdateTime(id, monitor);
					long diff = c.getDtLastUpdated().getTime()
							- convertDate(syncTime).getTime();
					// +/- 60 seconds error in comparison is ok
					if ((diff > -60000) && (diff < 60000)) {
						return false;
					}
				}
				for (AbstractTask task : tasks) {
					if (task instanceof FogBugzTask) {
						FogBugzTask t = (FogBugzTask) task;
						if (ids.contains(t.getTaskId())) {
							t.setStale(true);
						}
					}
				}
			} catch (FogBugzClientException e) {
				throw new CoreException(FogBugzStatus.createClientErrorStatus(
						repository, e));
			}

			return true;
		} finally {
			monitor.done();
		}
	}

	private Date convertDate(String dateString) {
		if (dateString == null || dateString.length() == 0) {
			return null;
		}
		try {
			return new SimpleDateFormat().parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateAttributes(TaskRepository arg0, IProgressMonitor arg1)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTaskFromRepository(TaskRepository repository,
			AbstractTask repositoryTask, IProgressMonitor monitor)
			throws CoreException {
		if (repositoryTask instanceof FogBugzTask) {
			try {
				FogBugzClient client = getClientManager().getClient(repository);
				Case fcase = client
						.getCase(repositoryTask.getTaskId(), monitor);
				FogBugzTask.updateTaskFromCase(repository.getUrl(),
						repositoryTask, fcase);
			} catch (FogBugzClientException e) {
				throw new CoreException(FogBugzStatus.createClientErrorStatus(
						repository, e));
			}
		}

	}

	@Override
	public void updateTaskFromTaskData(TaskRepository repository,
			AbstractTask task, RepositoryTaskData td) {
		if (task instanceof FogBugzTask) {
			FogBugzTask fogBugzTask = (FogBugzTask) task;
			fogBugzTask.setSummary(td.getAttributeValue(FogBugzAttribute.TITLE
					.getKey()));
			fogBugzTask.setOwner(td
					.getAttributeValue(FogBugzAttribute.OPENED_BY.getKey()));
			fogBugzTask.setTaskKind(td
					.getAttributeValue(FogBugzAttribute.CATEGORY.getKey()));
			fogBugzTask.setUrl(repository.getUrl() + FogBugzConstants.URL_TASK
					+ td.getId());
			String priority = td.getAttributeValue(FogBugzAttribute.PRIORITY
					.getKey());
			// Strip off description text, See FogBugzAttributeAdapter for
			// details on format
			fogBugzTask.setPriority(priority.charAt(0) + "");
			String due = td.getAttributeValue(FogBugzAttribute.DUE_DATE
					.getKey());
			try {
				if (due != null && !due.equals("")) {
					Date date = new SimpleDateFormat(
							FogBugzConstants.DATE_PATTERN).parse(due);
					fogBugzTask.setDueDate(date);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}

	public FogBugzClientManager getClientManager() {
		if (null == clientManager) {
			clientManager = new FogBugzClientManager();
		}
		return clientManager;
	}
}
