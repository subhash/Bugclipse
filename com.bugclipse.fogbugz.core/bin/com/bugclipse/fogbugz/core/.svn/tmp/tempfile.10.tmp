package com.bugclipse.fogbugz.core;

public class FogBugzConstants {

	final public static String URL_TASK = "/default.asp?pg=pgEditBug&command=view&ixBug=";

	final public static String URL_NEW_TASK = "/default.asp?command=new&pg=pgEditBug";

	final public static String URL_FILTERED_CASES = "/default.asp?pg=pgList&pre=preLoadFilter&ixFilter=";

	final public static String URL_EDIT_FILTER = "/default.asp?pg=pgSavedFilter&ixFilter=";

	final public static String URL_MYCASES = "/default.asp?pg=pgList&pre=preSaveFilterEZ&ixPersonAssignedTo=";

	final public static String URL_INBOX = "/default.asp?pg=pgList&pre=preSaveInboxFilter";

	final public static String URL_MANAGE_FILTERS = "${serverUrl}/default.asp?pg=pgManageFilters";

	final public static String URL_HOME_PAGE = "${serverUrl}/default.asp";

	final public static String URL_TASK_PREFIX = "${serverUrl}" + URL_TASK;

	final public static String PATTERN_EXTRACT_FILTERS = "<a href.+?title\\=\"Edit\".+?/>.+?<a href.+?title\\=\"Delete\".+?/>.+?<td align\\=\"left\">.+?<a href\\=\".+?ixFilter\\=(.+?)\">(.+?)</a>.+?<td align\\=\"left\">(.+?)</a>.+?</td>";

	final public static String PATTERN_EXTRACT_CASES = "<tr class=\"g-r.+?<td class=\"col_2\" id=\"col_2\">.+?<a href=\".+?ixBug=([0-9]+?).+?\"><fb:cv>(.+?)</fb:cv></a>.+?</td>.+?</tr>";

	final public static String PATTERN_EXTRACT_DEFAULT_FILTERS = "<ul class=\"highlight\">.+?<li class=\"highlight\">.+?<a href=\".+?ixPersonAssignedTo=(.+?)\">(.+?)</a>.+?</li>.+?</ul>";

	final public static String DATE_PATTERN = "EEE, d MMM yyyy HH:mm z";

	final public static String UTC_PATTERN = "yyyy-MM-dd HH:mm";

	final public static String LABEL_TIME_TRACKING = "FogBugz Time Tracking";
	
	public static final String MOST_RECENT_QUERY = "org.eclipse.mylyn.fogbugz.query.last";

}
