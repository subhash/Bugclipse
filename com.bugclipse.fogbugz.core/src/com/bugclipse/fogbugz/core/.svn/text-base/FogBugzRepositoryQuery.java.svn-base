package com.bugclipse.fogbugz.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;

import com.bugclipse.fogbugz.api.Filter;

public class FogBugzRepositoryQuery extends AbstractRepositoryQuery {

	private String queryPattern;

	private Map<String, String> params;

	private String taskPrefix;

	private String filterId;

	public FogBugzRepositoryQuery(String repositoryUrl, String queryUrl,
			String description) {
		super(description);
		setRepositoryUrl(repositoryUrl);
		setUrl(queryUrl);
		queryPattern = FogBugzConstants.PATTERN_EXTRACT_CASES;
		params = new HashMap<String, String>();
		taskPrefix = FogBugzConstants.URL_TASK_PREFIX;
	}

	public FogBugzRepositoryQuery(String repositoryUrl, Filter filter) {
		super(filter.getContent());
		setRepositoryUrl(repositoryUrl);
		setUrl(repositoryUrl + FogBugzConstants.URL_EDIT_FILTER
				+ filter.getSFilter());
		this.filterId = filter.getSFilter();
	}

	@Override
	public String getRepositoryKind() {
		return FogBugzCorePlugin.REPOSITORY_KIND;
	}

	public String getQueryPattern() {
		return this.queryPattern;
	}

	public Map<String, String> getParams() {
		return this.params;
	}

	public String getTaskPrefix() {
		return this.taskPrefix;
	}

	public String getFilterId() {
		return filterId;
	}

	public void setFilterId(String filterId) {
		this.filterId = filterId;
	}

}
