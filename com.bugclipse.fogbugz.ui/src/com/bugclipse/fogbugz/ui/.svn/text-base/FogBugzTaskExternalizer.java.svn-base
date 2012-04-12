package com.bugclipse.fogbugz.ui;

public class FogBugzTaskExternalizer {
	
}
//
//import org.eclipse.mylyn.internal.tasks.core.TaskExternalizationException;
//import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;
//import org.eclipse.mylyn.tasks.core.AbstractTaskContainer;
//import org.eclipse.mylyn.tasks.core.TaskList;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import com.bugclipse.fogbugz.core.FogBugzQueryHit;
//import com.bugclipse.fogbugz.core.FogBugzRepositoryQuery;
//import com.bugclipse.fogbugz.core.FogBugzRepositoryTask;
//
//public class FogBugzTaskExternalizer extends DelegatingTaskExternalizer {
//
//	private static final String KEY_FOGBUGZ = "FogBugz";
//
//	private static final String KEY_FOGBUGZ_CATEGORY = KEY_FOGBUGZ
//			+ KEY_CATEGORY;
//
//	private static final String KEY_FOGBUGZ_TASK = KEY_FOGBUGZ + KEY_TASK;
//
//	private static final String KEY_FOGBUGZ_QUERY_HIT = KEY_FOGBUGZ
//			+ KEY_QUERY_HIT;
//
//	private static final String KEY_FOGBUGZ_QUERY = KEY_FOGBUGZ + KEY_QUERY;
//
//	@Override
//	public boolean canCreateElementFor(AbstractQueryHit hit) {
//		return hit instanceof FogBugzQueryHit;
//	}
//
//	@Override
//	public boolean canCreateElementFor(AbstractRepositoryQuery query) {
//		return query instanceof FogBugzRepositoryQuery;
//	}
//
//	@Override
//	public boolean canCreateElementFor(ITask task) {
//		return task instanceof FogBugzRepositoryTask;
//	}
//
//	@Override
//	public boolean canReadCategory(Node node) {
//		return node.getNodeName().equals(KEY_FOGBUGZ_CATEGORY);
//	}
//
//	@Override
//	public boolean canReadQuery(Node node) {
//		return node.getNodeName().equals(KEY_FOGBUGZ_QUERY);
//	}
//
//	@Override
//	public boolean canReadQueryHit(Node node) {
//		return node.getNodeName().equals(KEY_FOGBUGZ_QUERY_HIT);
//	}
//
//	@Override
//	public Element createQueryElement(AbstractRepositoryQuery arg0,
//			Document arg1, Element arg2) {
//		return super.createQueryElement(arg0, arg1, arg2);
//	}
//
//	@Override
//	public String getCategoryTagName() {
//		return KEY_FOGBUGZ_CATEGORY;
//	}
//
//	@Override
//	public String getQueryHitTagName() {
//		return KEY_QUERY_HIT;
//	}
//
//	@Override
//	public String getQueryTagNameForElement(AbstractRepositoryQuery query) {
//		if (query instanceof FogBugzRepositoryQuery) {
//			return KEY_FOGBUGZ_QUERY;
//		}
//		return super.getQueryTagNameForElement(query);
//	}
//
//	@Override
//	public String getTaskTagName() {
//		return KEY_FOGBUGZ_TASK;
//	}
//
//	@Override
//	public AbstractRepositoryQuery readQuery(Node node, TaskList taskList)
//			throws TaskExternalizationException {
//		Element elem = (Element) node;
//		String repositoryUrl = "", queryUrl = "", desc = "";
//
//		if (elem.hasAttribute(KEY_REPOSITORY_URL)) {
//			repositoryUrl = elem.getAttribute(KEY_REPOSITORY_URL);
//		} else
//			throw new TaskExternalizationException(
//					"Repository URL not stored in query");
//
//		if (elem.hasAttribute(KEY_QUERY_STRING)) {
//			queryUrl = elem.getAttribute(KEY_QUERY_STRING);
//		} else
//			throw new TaskExternalizationException(
//					"Query URL not stored in query");
//
//		if (elem.hasAttribute(KEY_NAME)) {
//			desc = elem.getAttribute(KEY_NAME);
//		} else
//			throw new TaskExternalizationException(
//					"Description not stored in query");
//
//		FogBugzRepositoryQuery q = new FogBugzRepositoryQuery(repositoryUrl,
//				queryUrl, desc, taskList);
//
//		NodeList list = node.getChildNodes();
//		for (int i = 0; i < list.getLength(); i++) {
//			Node child = list.item(i);
//			try {
//				readQueryHit(child, taskList, q);
//			} catch (TaskExternalizationException e) {
//				MylarStatusHandler.log(e, e.getMessage());
//			}
//		}
//
//		return q;
//	}
//
//	@Override
//	public void readQueryHit(Node node, TaskList taskList,
//			AbstractRepositoryQuery query) throws TaskExternalizationException {
//		Element elem = (Element) node;
//		String taskId = "", repositoryUrl = "";
//		if (elem.hasAttribute(KEY_HANDLE)) {
//			String handle = elem.getAttribute(KEY_HANDLE);
//			taskId = AbstractRepositoryTask.getTaskId(handle);
//			repositoryUrl = AbstractRepositoryTask.getRepositoryUrl(handle);
//		} else
//			throw new TaskExternalizationException(
//					"Handle not stored in query hit");
//		FogBugzQueryHit hit = new FogBugzQueryHit(taskList, repositoryUrl, "",
//				taskId, "");
//		if (elem.hasAttribute(KEY_COMPLETE)
//				&& elem.getAttribute(KEY_COMPLETE).compareTo(VAL_TRUE) == 0) {
//			hit.setCompleted(true);
//		} else {
//			hit.setCompleted(false);
//		}
//		readQueryHitInfo(hit, taskList, query, elem);
//	}
//
//	@Override
//	public ITask readTask(Node node, TaskList taskList,
//			AbstractTaskContainer category, ITask parent)
//			throws TaskExternalizationException {
//		Element element = (Element) node;
//		String handle;
//		String label;
//		if (element.hasAttribute(KEY_HANDLE)) {
//			handle = element.getAttribute(KEY_HANDLE);
//		} else {
//			throw new TaskExternalizationException("Handle not stored for task");
//		}
//		if (element.hasAttribute(KEY_LABEL)) {
//			label = element.getAttribute(KEY_LABEL);
//		} else {
//			throw new TaskExternalizationException(
//					"Description not stored for task");
//		}
//
//		FogBugzRepositoryTask task = new FogBugzRepositoryTask(handle, label, false);
//		readTaskInfo(task, taskList, element, parent, category);
//		return task;
//	}
//
//}
