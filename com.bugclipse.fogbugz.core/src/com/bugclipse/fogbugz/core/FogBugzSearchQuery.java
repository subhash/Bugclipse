package com.bugclipse.fogbugz.core;

import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;

public class FogBugzSearchQuery extends AbstractRepositoryQuery {

	private String searchText;

	public FogBugzSearchQuery(String repositoryUrl, String description,
			String searchText) {
		super(description);
		setRepositoryUrl(repositoryUrl);
		this.searchText = searchText;
	}

	@Override
	public String getRepositoryKind() {
		return FogBugzCorePlugin.REPOSITORY_KIND;
	}

	public String getSearchText() {
		return searchText;
	}

}
