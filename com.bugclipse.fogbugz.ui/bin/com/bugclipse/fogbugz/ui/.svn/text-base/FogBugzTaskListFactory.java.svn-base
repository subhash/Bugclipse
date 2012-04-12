package com.bugclipse.fogbugz.ui;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;
import org.eclipse.mylyn.tasks.core.AbstractTask;
import org.eclipse.mylyn.tasks.core.AbstractTaskListFactory;
import org.w3c.dom.Element;

import com.bugclipse.fogbugz.core.FogBugzRepositoryQuery;
import com.bugclipse.fogbugz.core.FogBugzTask;

public class FogBugzTaskListFactory extends AbstractTaskListFactory {

	private static final String KEY_FOGBUGZ = "fogbugz";
	
	private static final String KEY_FILTER_ID = "filterId";

	private static final String KEY_FOGBUGZ_TASK = KEY_FOGBUGZ + KEY_TASK;

	private static final String KEY_FOGBUGZ_QUERY = KEY_FOGBUGZ + KEY_QUERY;
	
	private static final String KEY_FOGBUGZ_QUERY_FILTER_ID = KEY_FOGBUGZ_QUERY + KEY_FILTER_ID;

	@Override
	public boolean canCreate(AbstractTask task) {
		return task instanceof FogBugzTask;
	}

	@Override
	public boolean canCreate(AbstractRepositoryQuery query) {
		return query instanceof FogBugzRepositoryQuery;
	}

	@Override
	public AbstractTask createTask(String repositoryUrl, String taskId,
			String summary, Element element) {
		return new FogBugzTask(repositoryUrl, taskId, summary);
	}

	@Override
	public AbstractRepositoryQuery createQuery(String repositoryUrl,
			String queryString, String label, Element element) {
		FogBugzRepositoryQuery q = new FogBugzRepositoryQuery(repositoryUrl, queryString, label);
		q.setFilterId(element.getAttribute(KEY_FOGBUGZ_QUERY_FILTER_ID));
		return q;
	}

	@Override
	public String getTaskElementName() {
		return KEY_FOGBUGZ_TASK;
	}

	@Override
	public Set<String> getQueryElementNames() {
		Set<String> names = new HashSet<String>();
		names.add(KEY_FOGBUGZ_QUERY);
		return names;
	}

	@Override
	public String getQueryElementName(AbstractRepositoryQuery query) {
		return query instanceof FogBugzRepositoryQuery ? KEY_FOGBUGZ_QUERY : "";
	}
	
	@Override
	public void setAdditionalAttributes(AbstractRepositoryQuery query, Element element) {
		if(query instanceof FogBugzRepositoryQuery){
			FogBugzRepositoryQuery q = (FogBugzRepositoryQuery) query;
			element.setAttribute(KEY_FOGBUGZ_QUERY_FILTER_ID, q.getFilterId());
		}
	}

}
