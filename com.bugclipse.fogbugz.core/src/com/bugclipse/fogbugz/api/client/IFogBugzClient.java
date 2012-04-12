package com.bugclipse.fogbugz.api.client;

public interface IFogBugzClient {

	public static final String LOGIN_URL = "/api.asp?cmd=logon&email=${userId}&password=${password}";

	public static final String LIST_PROJECTS_URL = "/api.asp?cmd=listProjects";

	public static final String LIST_FILTERS_URL = "/api.asp?cmd=listFilters";

	public static final String LIST_CASES_URL = "/api.asp?cmd=search&q=";

	public static final String LIST_CASES_SINCE_URL = "/api.asp?cmd=search&q=";

	public static final String LIST_AREAS_URL = "/api.asp?cmd=listAreas";

	public static final String LIST_FIXFORS_URL = "/api.asp?cmd=listFixFors";

	public static final String LIST_CATEGORIES_URL = "/api.asp?cmd=listCategories";

	public static final String LIST_STATUSES_URL = "/api.asp?cmd=listStatuses";

	public static final String LIST_RESOLVED_STATUSES_URL = "/api.asp?cmd=listStatuses&fResolved=1";

	public static final String LIST_PRIORITIES_URL = "/api.asp?cmd=listPriorities";

	public static final String LIST_PEOPLE_URL = "/api.asp?cmd=listPeople&fIncludeVirtual=1&fIncludeNormal=1";

	public static final String VIEW_PERSON_URL = "/api.asp?cmd=viewPerson&ixPerson=";

	public static final String EDIT_CASE_URL = "/api.asp?cmd=edit&ixBug=";

	public static final String ASSIGN_CASE_URL = "/api.asp?cmd=assign&ixBug=";

	public static final String REACTIVATE_CASE_URL = "/api.asp?cmd=reactivate&ixBug=";

	public static final String REOPEN_CASE_URL = "/api.asp?cmd=reopen&ixBug=";

	public static final String RESOLVE_CASE_URL = "/api.asp?cmd=resolve&ixBug=";

	public static final String CLOSE_CASE_URL = "/api.asp?cmd=close&ixBug=";

	public static final String NEW_CASE_URL = "/api.asp?cmd=new";

	public static final String START_WORK_URL = "/api.asp?cmd=startWork&ixBug=";

	public static final String STOP_WORK_URL = "/api.asp?cmd=stopWork";

	public static final String LIST_INTERVALS_URL = "/api.asp?cmd=listIntervals";

	public static final String SET_CURRENT_FILTER_URL = "/api.asp?cmd=saveFilter&sFilter=";
	
	public static final String SEARCH_CASES_URL = "/api.asp?cmd=search&q=";

}
