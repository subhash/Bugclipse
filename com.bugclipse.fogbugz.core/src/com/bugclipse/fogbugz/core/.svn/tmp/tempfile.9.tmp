package com.bugclipse.fogbugz.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.mylyn.tasks.core.AbstractAttachmentHandler;
import org.eclipse.mylyn.tasks.core.AbstractAttributeFactory;
import org.eclipse.mylyn.tasks.core.AbstractTask;
import org.eclipse.mylyn.tasks.core.AbstractTaskDataHandler;
import org.eclipse.mylyn.tasks.core.RepositoryAttachment;
import org.eclipse.mylyn.tasks.core.RepositoryOperation;
import org.eclipse.mylyn.tasks.core.RepositoryTaskAttribute;
import org.eclipse.mylyn.tasks.core.RepositoryTaskData;
import org.eclipse.mylyn.tasks.core.TaskComment;
import org.eclipse.mylyn.tasks.core.TaskRepository;

import com.bugclipse.fogbugz.api.AttachmentContained;
import com.bugclipse.fogbugz.api.Case;
import com.bugclipse.fogbugz.api.CaseResponse;
import com.bugclipse.fogbugz.api.EventContained;
import com.bugclipse.fogbugz.api.Person;
import com.bugclipse.fogbugz.api.Status;
import com.bugclipse.fogbugz.api.client.FogBugzClient;
import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.api.exception.FogBugzStatus;
import com.bugclipse.fogbugz.core.FogBugzAttributeFactory.FogBugzAttribute;

public class FogBugzTaskDataHandler extends AbstractTaskDataHandler {

	private AbstractAttributeFactory attributeFactory = new FogBugzAttributeFactory();

	private FogBugzRepositoryConnector connector;

	// TODO move all these static strings to proper classes.

	public static final String REASSIGN_OPERATION = "Reassign To";

	public static final String LEAVE_OPERATION = "Leave as ";

	public static final String REOPEN_OPERATION = "Reopen";

	public static final String CLOSE_OPERATION = "Close";

	public static final String RESOLVE_OPERATION = "Resolve";

	public static final String RESOLVE_CLOSE_OPERATION = "Resolve and Close";

	public static final String REACTIVATE_OPERATION = "Reactivate";

	public FogBugzTaskDataHandler(FogBugzRepositoryConnector connector) {
		this.connector = connector;
	}

	@Override
	public RepositoryTaskData getTaskData(TaskRepository repository,
			String taskId, IProgressMonitor monitor) throws CoreException {
		try {
			FogBugzClient client = connector.getClientManager().getClient(
					repository);
			// TODO add code to update cached details with the latest info from
			// repository
			Case fcase = client.getCase(taskId, monitor);
			if (fcase != null) {
				return createTaskData(repository, client, fcase, null);
			}
		} catch (FogBugzClientException e) {
			throw new CoreException(FogBugzStatus.createClientErrorStatus(
					repository, e));
		}
		return null;
	}

	public Map<String, RepositoryTaskData> getTaskData(
			TaskRepository repository, Set<String> taskIds,
			IProgressMonitor monitor) throws CoreException {
		Map<String, RepositoryTaskData> taskData = new HashMap<String, RepositoryTaskData>();
		try {
			FogBugzClient client = connector.getClientManager().getClient(
					repository);
			Map<String, Case> fcase = client.getCases(taskIds, monitor);
			if (fcase != null) {
				for (Entry<String, Case> entry : fcase.entrySet()) {
					taskData.put(entry.getKey(), createTaskData(repository,
							client, entry.getValue(), null));
				}
			}
		} catch (FogBugzClientException e) {
			throw new CoreException(FogBugzStatus.createClientErrorStatus(
					repository, e));
		}
		return taskData;
	}

	public RepositoryTaskData createTaskData(TaskRepository repository,
			FogBugzClient client, Case fcase, AbstractTask oldTask)
			throws FogBugzClientException {
		RepositoryTaskData data = new RepositoryTaskData(attributeFactory,
				FogBugzCorePlugin.REPOSITORY_KIND, repository.getUrl(), fcase
						.getIxBug()
						+ "");
		createDefaultAttributes(attributeFactory, data, fcase, client, true);
		updateTaskData(repository, client, attributeFactory, data, fcase);
		return data;
	}

	private void updateTaskData(TaskRepository repository,
			FogBugzClient client, AbstractAttributeFactory factory,
			RepositoryTaskData data, Case fcase) throws FogBugzClientException {
		data.setAttributeValue(FogBugzAttribute.TITLE.getKey(), fcase
				.getSTitle());
		// data.setAttributeValue(FogBugzAttribute.DESCRIPTION.getKey(), fcase
		// .getSLatestTextSummary());
		data.setAttributeValue(FogBugzAttribute.STATUS.getKey(), fcase
				.getSStatus());
		data.setAttributeValue(FogBugzAttribute.ID.getKey(), fcase.getIxBug()
				+ "");
		data.setAttributeValue(FogBugzAttribute.DT_OPENED.getKey(),
				new SimpleDateFormat().format(fcase.getDtOpened()));
		data.setAttributeValue(FogBugzAttribute.DT_LAST_UPDATED.getKey(),
				new SimpleDateFormat().format(fcase.getDtLastUpdated()));
		// data.setAttributeValue(FogBugzAttribute.RESOLUTION.getKey(), //
		// fcase.isFOpen() ? "" : fcase.getSStatus());
		data.setAttributeValue(FogBugzAttribute.ASSIGNED_TO.getKey(), fcase
				.getSPersonAssignedTo());
		Person openedBy = client.getPerson(fcase.getIxPersonOpenedBy() + "");
		data.setAttributeValue(FogBugzAttribute.OPENED_BY.getKey(), openedBy
				.getSFullName());
		data.setAttributeValue(FogBugzAttribute.PROJECT.getKey(), fcase
				.getSProject());
		data.setAttributeValue(FogBugzAttribute.PRIORITY.getKey(), fcase
				.getIxPriority()
				+ " - " + fcase.getSPriority());

		data
				.setAttributeValue(FogBugzAttribute.AREA.getKey(), fcase
						.getSArea());
		data.setAttributeValue(FogBugzAttribute.CATEGORY.getKey(), fcase
				.getSCategory());
		RepositoryTaskAttribute fixForAttr = data
				.getAttribute(FogBugzAttribute.FIXFOR.getKey());
		RepositoryTaskAttribute fixForOptionAttr = data.getAttribute(fcase
				.getSProject()
				+ FogBugzAttributeFactory.filler
				+ FogBugzAttribute.FIXFOR.getKey());
		for (String opt : fixForOptionAttr.getOptions()) {
			fixForAttr.addOption(opt, fixForOptionAttr.getOptionParameter(opt));
		}
		String fixfor = FogBugzAttributeAdapter.optionFromParam(fixForAttr,
				fcase.getSFixFor());
		data.setAttributeValue(FogBugzAttribute.FIXFOR.getKey(), fixfor);
		data.setAttributeValue(FogBugzAttribute.COMPUTER.getKey(), fcase
				.getSComputer());
		data.setAttributeValue(FogBugzAttribute.VERSION.getKey(), fcase
				.getSVersion());
		data.setAttributeValue(FogBugzAttribute.CURRENT_ESTIMATE.getKey(),
				fcase.getHrsCurrEst() + "");
		if (fcase.getDtDue() != null) {
			String dateString = FogBugzAttributeAdapter.toLocalTZFormat(fcase
					.getDtDue());
			data.setAttributeValue(FogBugzAttribute.DUE_DATE.getKey(),
					dateString);
		}
		if (fcase.getHrsCurrEst() != 0)
			data.setAttributeValue(FogBugzAttribute.HRS_ELAPSED.getKey(), fcase
					.getHrsElapsed()
					+ "");
		else
			data.removeAttribute(FogBugzAttribute.HRS_ELAPSED.getKey());
		if (fcase.getHrsOrigEst() != 0)
			data.setAttributeValue(FogBugzAttribute.ORIGINAL_ESTIMATE.getKey(),
					fcase.getHrsOrigEst() + "");
		else
			data.removeAttribute(FogBugzAttribute.ORIGINAL_ESTIMATE.getKey());

		EventContained[] events = fcase.getEventsContained()
				.getEventContained();
		for (EventContained event : events) {
			String creator = event.getSPerson();
			String date = new SimpleDateFormat().format(event.getDt());
			String eventDescription = event.getEvtDescription();
			TaskComment taskComment = new TaskComment(attributeFactory, data
					.getComments().size() + 1);
			taskComment.setAttributeValue(
					RepositoryTaskAttribute.COMMENT_AUTHOR, eventDescription);
			taskComment.setAttributeValue(RepositoryTaskAttribute.COMMENT_DATE,
					date);
			taskComment.setAttributeValue(RepositoryTaskAttribute.COMMENT_TEXT,
					event.getSChanges() + "\n" + event.getS());
			data.addComment(taskComment);
			AttachmentContained[] attachments = event
					.getRgAttachmentsContained().getAttachmentContained();
			for (int i = 0; i < attachments.length; i++) {
				AttachmentContained attachment = attachments[i];
				RepositoryAttachment taskAttachment = new RepositoryAttachment(
						factory);
				taskAttachment.setCreator(creator);
				taskAttachment
						.setRepositoryKind(FogBugzCorePlugin.REPOSITORY_KIND);
				taskAttachment.setRepositoryUrl(repository.getUrl());
				taskAttachment.setTaskId(data.getId());
				String desc;
				// Hack to get mylyn context attachment handler to recognize
				// contexts
				if (attachment.getSFileName().equals(
						AbstractAttachmentHandler.MYLAR_CONTEXT_FILENAME))
					desc = AbstractAttachmentHandler.MYLAR_CONTEXT_DESCRIPTION;
				else
					desc = attachment.getSFileName();
				taskAttachment.setAttributeValue(FogBugzAttribute.DESCRIPTION
						.getKey(), desc);
				taskAttachment.setAttributeValue(
						RepositoryTaskAttribute.ATTACHMENT_FILENAME, attachment
								.getSFileName());
				taskAttachment.setAttributeValue(
						RepositoryTaskAttribute.USER_OWNER, creator);
				if (date != null) {
					taskAttachment.setAttributeValue(
							RepositoryTaskAttribute.ATTACHMENT_DATE, date);
				}
				taskAttachment.setAttributeValue(
						RepositoryTaskAttribute.ATTACHMENT_URL, repository
								.getUrl()
								+ "/" + attachment.getSURL());
				taskAttachment.setAttributeValue(
						RepositoryTaskAttribute.ATTACHMENT_ID, i + "");
				data.addAttachment(taskAttachment);

			}
		}

		String[] actions = client.getActions(fcase);
		if (actions != null) {
			// add operations in a defined order
			List<String> actionList = new ArrayList<String>(Arrays
					.asList(actions));
			addOperation(repository, data, client, fcase, actionList,
					LEAVE_OPERATION);
			addOperation(repository, data, client, fcase, actionList,
					REASSIGN_OPERATION);
			addOperation(repository, data, client, fcase, actionList,
					REOPEN_OPERATION);
			addOperation(repository, data, client, fcase, actionList,
					RESOLVE_OPERATION);
			addOperation(repository, data, client, fcase, actionList,
					RESOLVE_CLOSE_OPERATION);
			addOperation(repository, data, client, fcase, actionList,
					REACTIVATE_OPERATION);
			addOperation(repository, data, client, fcase, actionList,
					CLOSE_OPERATION);
		}

		// if (lastChanged != null) {
		// data.setAttributeValue(Attribute.CHANGE_TIME.getTracKey(),
		// TracUtils.toTracTime(lastChanged) + "");
		// }
	}

	public void createDefaultAttributes(AbstractAttributeFactory factory,
			RepositoryTaskData data, Case fcase, FogBugzClient client,
			boolean existingTask) throws FogBugzClientException {
		FogBugzAttributeAdapter attrAdapter = new FogBugzAttributeAdapter(
				client);
		if (existingTask) {
			createAttribute(factory, data, FogBugzAttribute.STATUS);
			createAttribute(factory, data, FogBugzAttribute.ORIGINAL_ESTIMATE);
			createAttribute(factory, data, FogBugzAttribute.HRS_ELAPSED);

		}
		createAttribute(factory, data, FogBugzAttribute.CURRENT_ESTIMATE);
		createAttribute(factory, data, FogBugzAttribute.DUE_DATE);
		Map<String, String> priorOptions = attrAdapter.getPriorityOptions();
		createAttribute(factory, data, FogBugzAttribute.PRIORITY, priorOptions);
		String defaultPriority = "";
		for (Entry<String, String> entry : priorOptions.entrySet()) {
			if (entry.getValue().equals("3")) {
				defaultPriority = entry.getKey();
				break;
			}
		}
		data.setAttributeValue(FogBugzAttribute.PRIORITY.getKey(),
				defaultPriority);

		// Project
		ArrayList<String> projects = attrAdapter
				.getOptions(FogBugzAttribute.PROJECT);
		createAttribute(factory, data, FogBugzAttribute.PROJECT, projects);
		String defaultProject = projects.get(0);
		data.setAttributeValue(FogBugzAttribute.PROJECT.getKey(),
				defaultProject);

		// Area
		createAttribute(factory, data, FogBugzAttribute.AREA);
		HashMap<String, ArrayList<String>> areas = client.getAreaOptions();
		for (String project : projects) {
			createSpecialAttribute(data, project
					+ FogBugzAttributeFactory.filler
					+ FogBugzAttribute.AREA.getKey(), project, areas
					.get(project));
		}
		data.setAttributeValue(FogBugzAttribute.AREA.getKey(), areas.get(
				defaultProject).get(0));

		// FixFor
		createAttribute(factory, data, FogBugzAttribute.FIXFOR);
		HashMap<String, HashMap<String, String>> fixFor = client
				.getFixForOptions(projects);
		for (String project : projects) {
			createSpecialAttribute(data, project
					+ FogBugzAttributeFactory.filler
					+ FogBugzAttribute.FIXFOR.getKey(), project, fixFor
					.get(project));
		}
		HashMap<String, String> f = fixFor.get(defaultProject);
		RepositoryTaskAttribute fixforAttr = data
				.getAttribute(FogBugzAttribute.FIXFOR.getKey());
		for (String key : f.keySet()) {
			fixforAttr.addOption(key, f.get(key));
		}
		data.setAttributeValue(FogBugzAttribute.FIXFOR.getKey(), f.keySet()
				.toArray()[0].toString());

		ArrayList<String> categoryOptions = attrAdapter
				.getOptions(FogBugzAttribute.CATEGORY);
		// Category
		createAttribute(factory, data, FogBugzAttribute.CATEGORY,
				categoryOptions);
		data.setAttributeValue(FogBugzAttribute.CATEGORY.getKey(),
				categoryOptions.get(0));
		createAttribute(factory, data, FogBugzAttribute.COMPUTER);
		createAttribute(factory, data, FogBugzAttribute.VERSION);
		createAttribute(factory, data, FogBugzAttribute.ASSIGNED_TO,
				attrAdapter.getOptions(FogBugzAttribute.ASSIGNED_TO));
		if (existingTask) {
			createAttribute(factory, data, FogBugzAttribute.OPENED_BY);
		}
		createAttribute(factory, data, FogBugzAttribute.TITLE);
		// createAttribute(factory, data, FogBugzAttribute.DESCRIPTION);
		createAttribute(factory, data, FogBugzAttribute.DT_OPENED);
		createAttribute(factory, data, FogBugzAttribute.DT_LAST_UPDATED);
		createAttribute(factory, data, FogBugzAttribute.CC);
		if (!existingTask) {
			// createAttribute(factory, data, FogBugzAttribute.TITLE);
			// createAttribute(factory, data, FogBugzAttribute.DESCRIPTION);
			// createAttribute(factory, data, FogBugzAttribute.DT_OPENED);
			// createAttribute(factory, data, FogBugzAttribute.DT_LAST_UPDATED);
		}
	}

	private static RepositoryTaskAttribute createSpecialAttribute(
			RepositoryTaskData data, String id, String name,
			ArrayList<String> options) {
		RepositoryTaskAttribute attribute = new RepositoryTaskAttribute(id,
				name, true);
		if (options != null)
			for (String opt : options) {
				attribute.addOption(opt, opt);
			}
		attribute.setReadOnly(true);
		data.addAttribute(id, attribute);
		return attribute;
	}

	private static RepositoryTaskAttribute createSpecialAttribute(
			RepositoryTaskData data, String id, String name,
			HashMap<String, String> options) {
		RepositoryTaskAttribute attribute = new RepositoryTaskAttribute(id,
				name, true);
		if (options != null)
			for (String opt : options.keySet()) {
				attribute.addOption(opt, options.get(opt));
			}
		attribute.setReadOnly(true);
		data.addAttribute(id, attribute);
		return attribute;
	}

	private static RepositoryTaskAttribute createAttribute(
			AbstractAttributeFactory factory, RepositoryTaskData data,
			FogBugzAttribute attribute, ArrayList<String> values) {
		RepositoryTaskAttribute attr = factory.createAttribute(attribute
				.getKey());
		if (values != null) {
			for (String value : values) {
				attr.addOption(value, value);
			}
		} else {
			// attr.setHidden(true);
			attr.setReadOnly(true);
		}
		data.addAttribute(attribute.getKey(), attr);
		return attr;
	}

	private static RepositoryTaskAttribute createAttribute(
			AbstractAttributeFactory factory, RepositoryTaskData data,
			FogBugzAttribute attribute, Map<String, String> values) {
		RepositoryTaskAttribute attr = factory.createAttribute(attribute
				.getKey());
		if (values != null) {
			for (String value : values.keySet()) {
				attr.addOption(value, values.get(value));
			}
		} else {
			// attr.setHidden(true);
			attr.setReadOnly(true);
		}
		data.addAttribute(attribute.getKey(), attr);
		return attr;
	}

	private static RepositoryTaskAttribute createAttribute(
			AbstractAttributeFactory factory, RepositoryTaskData data,
			FogBugzAttribute attribute) {
		RepositoryTaskAttribute attr = factory.createAttribute(attribute
				.getKey());
		data.addAttribute(attribute.getKey(), attr);
		return attr;
	}

	private static void addOperation(TaskRepository repository,
			RepositoryTaskData data, FogBugzClient client, Case fcase,
			List<String> actions, String action) throws FogBugzClientException {
		if (!actions.remove(action)) {
			return;
		}

		RepositoryOperation operation = null;
		if (LEAVE_OPERATION.equals(action)) {
			operation = new RepositoryOperation(LEAVE_OPERATION, "Leave as "
					+ fcase.getSStatus());
			operation.setChecked(true);
		} else if (RESOLVE_OPERATION.equals(action)) {
			operation = new RepositoryOperation(action, RESOLVE_OPERATION);
			operation.setUpOptions("resolution");
			for (Status resolution : client.getResolvedStatuses(fcase
					.getIxCategory())) {
				operation.addOption(resolution.getSStatus(), resolution
						.getIxStatus()
						+ "");
			}
		} else if (RESOLVE_CLOSE_OPERATION.equals(action)) {
			operation = new RepositoryOperation(action, RESOLVE_CLOSE_OPERATION);
			operation.setUpOptions("resolution");
			for (Status resolution : client.getResolvedStatuses(fcase
					.getIxCategory())) {
				operation.addOption(resolution.getSStatus(), resolution
						.getIxStatus()
						+ "");
			}
		} else if (REASSIGN_OPERATION.equals(action)) {
			operation = new RepositoryOperation(action, REASSIGN_OPERATION);
			operation.setInputName("owner");
			operation.setInputValue(fcase.getSPersonAssignedTo());
			operation.setUpOptions("assignTo");
			FogBugzAttributeAdapter attrAdapter = new FogBugzAttributeAdapter(
					client);
			for (String user : attrAdapter
					.getOptions(FogBugzAttribute.ASSIGNED_TO)) {
				operation.addOption(user, user);
			}
		} else if (REACTIVATE_OPERATION.equals(action)) {
			operation = new RepositoryOperation(action, REACTIVATE_OPERATION);
		} else if (REOPEN_OPERATION.equals(action)) {
			operation = new RepositoryOperation(action, REOPEN_OPERATION);
		} else if (CLOSE_OPERATION.equals(action)) {
			operation = new RepositoryOperation(action, CLOSE_OPERATION);
		}

		if (operation != null) {
			data.addOperation(operation);
		}
	}

	@Override
	public AbstractAttributeFactory getAttributeFactory(String repositoryUrl,
			String repositoryKind, String taskKind) {
		// we don't care about the repository information right now
		return attributeFactory;
	}

	@Override
	public AbstractAttributeFactory getAttributeFactory(
			RepositoryTaskData taskData) {
		return getAttributeFactory(taskData.getRepositoryUrl(), taskData
				.getRepositoryKind(), taskData.getTaskKind());
	}

	@Override
	public boolean initializeTaskData(TaskRepository repository,
			RepositoryTaskData data, IProgressMonitor monitor)
			throws CoreException {
		try {
			FogBugzClient client = connector.getClientManager().getClient(
					repository);
			createDefaultAttributes(attributeFactory, data, null, client, false);
			return true;
		} catch (FogBugzClientException e) {
			throw new CoreException(FogBugzStatus.createClientErrorStatus(
					repository, e));
		}
	}

	@Override
	public Set<String> getSubTaskIds(RepositoryTaskData arg0) {
		return Collections.emptySet();
	}

	@Override
	public String postTaskData(TaskRepository repository,
			RepositoryTaskData taskData, IProgressMonitor monitor)
			throws CoreException {
		HashMap<String, String> changedValues = new HashMap<String, String>();
		try {
			List<RepositoryTaskAttribute> attributes = taskData.getAttributes();
			for (RepositoryTaskAttribute attribute : attributes) {
				if (FogBugzAttributeFactory.isInternalAttribute(attribute
						.getId())) {
					// ignore
				} else if (!attribute.isReadOnly()) {
					String value = attribute.getValue();
					if (attribute.getId().equals(
							FogBugzAttribute.DUE_DATE.getKey())
							&& (value != null && !value.equals(""))) {
						try {
							value = FogBugzAttributeAdapter.toUTCFormat(value);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					changedValues.put(attribute.getId(), value);
				}
			}

			FogBugzClient client = connector.getClientManager().getClient(
					repository);
			if (taskData.isNew()) {
				CaseResponse response = client.createCase(changedValues,
						taskData.getDescription(), null);
				return response.getIxBug() + "";
			} else {
				RepositoryOperation operation = taskData.getSelectedOperation();
				if (operation == null)
					client.editCase(taskData.getId(), changedValues, taskData
							.getNewComment());
				else {
					if (LEAVE_OPERATION.equals(operation.getKnobName()))
						client.editCase(taskData.getId(), changedValues,
								taskData.getNewComment());
					if (RESOLVE_OPERATION.equals(operation.getKnobName())) {
						long ixStatus = Long
								.parseLong(operation.getOptionValue(operation
										.getOptionSelection()));
						if (changedValues.containsKey(FogBugzAttribute.STATUS
								.getKey()))
							changedValues.remove(FogBugzAttribute.STATUS
									.getKey());
						changedValues.put(FogBugzAttribute.STATUS.getKey(),
								operation.getOptionSelection());
						client.resolveCase(taskData.getId(), changedValues,
								taskData.getNewComment());
					}
					if (RESOLVE_CLOSE_OPERATION.equals(operation.getKnobName())) {
						long ixStatus = Long
								.parseLong(operation.getOptionValue(operation
										.getOptionSelection()));
						if (changedValues.containsKey(FogBugzAttribute.STATUS
								.getKey()))
							changedValues.remove(FogBugzAttribute.STATUS
									.getKey());
						changedValues.put(FogBugzAttribute.STATUS.getKey(),
								operation.getOptionSelection());
						client.resolveCase(taskData.getId(), changedValues,
								taskData.getNewComment());
						client.closeCase(taskData.getId(), changedValues,
								taskData.getNewComment());
					}
					if (REOPEN_OPERATION.equals(operation.getKnobName()))
						client.reopenCase(taskData.getId(), changedValues,
								taskData.getNewComment());
					if (REASSIGN_OPERATION.equals(operation.getKnobName())) {
						String newAssignee = operation.getOptionSelection();
						if (changedValues
								.containsKey(FogBugzAttribute.ASSIGNED_TO
										.getKey()))
							changedValues.remove(FogBugzAttribute.ASSIGNED_TO
									.getKey());
						changedValues.put(
								FogBugzAttribute.ASSIGNED_TO.getKey(),
								newAssignee);
						client.assignCase(taskData.getId(), changedValues,
								taskData.getNewComment());
					}
					if (REACTIVATE_OPERATION.equals(operation.getKnobName()))
						client.reactivateCase(taskData.getId(), changedValues,
								taskData.getNewComment());
					if (CLOSE_OPERATION.equals(operation.getKnobName()))
						client.closeCase(taskData.getId(), changedValues,
								taskData.getNewComment());

				}
				return null;
			}
		} catch (FogBugzClientException e) {
			throw new CoreException(FogBugzStatus.createClientErrorStatus(
					repository, e));
		}
	}

}
