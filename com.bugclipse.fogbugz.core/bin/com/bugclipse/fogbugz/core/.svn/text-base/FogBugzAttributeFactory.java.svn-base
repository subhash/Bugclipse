package com.bugclipse.fogbugz.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.mylyn.tasks.core.AbstractAttributeFactory;
import org.eclipse.mylyn.tasks.core.RepositoryTaskAttribute;

public class FogBugzAttributeFactory extends AbstractAttributeFactory {
	public static String filler = "_";

	public enum FogBugzAttribute {
		ID("ID", "ID:", null, true), TITLE("sTitle", "Title:",
				RepositoryTaskAttribute.SUMMARY, true), PROJECT("sProject",
				"Project:", null), AREA("sArea", "Area:", null), FIXFOR(
				"sFixFor", "Fix For:", null), CATEGORY("sCategory",
				"Category:", null), STATUS("sStatus", "Status:",
				RepositoryTaskAttribute.STATUS, true, true), PRIORITY(
				"ixPriority", "Priority:", null), ORIGINAL_ESTIMATE(
				"hrsOrigEst", "Original Estimate [hrs]:", null, true, true), CURRENT_ESTIMATE(
				"hrsCurrEst", "Current Estimate [hrs]:", null, true), HRS_ELAPSED(
				"hrsElapsed", "Elapsed time [hrs]:", null, true, true), DUE_DATE(
				"dtDue", "Due:", null, true), DT_OPENED("dtOpened",
				"Opened On:", RepositoryTaskAttribute.DATE_CREATION, true, true), DT_LAST_UPDATED(
				"dtLastUpdated", "Last Updated On:",
				RepositoryTaskAttribute.DATE_MODIFIED, true, true), VERSION(
				"sVersion", "Version:", null), COMPUTER("sComputer",
				"Computer:", null), OPENED_BY("opened_by", "Opened by:",
				RepositoryTaskAttribute.USER_REPORTER, true, true), LAST_UPDATED_BY(
				"last_updated_by", "Last updated by:", null, false, true), ASSIGNED_TO(
				"sPersonAssignedTo", "Assigned To",
				RepositoryTaskAttribute.USER_ASSIGNED, false, false),
		// DESCRIPTION("description","Description",RepositoryTaskAttribute.DESCRIPTION,true,false),
		CC("cc", "CC:", RepositoryTaskAttribute.NEW_CC, true, false), DESCRIPTION(
				"description", "Description:",
				RepositoryTaskAttribute.DESCRIPTION, true, false);
		public static final String FOGBUGZ_DATE_FORMAT = "dd MMM yyyy HH:mm:ss z";

		private final boolean isHidden;

		private final boolean isReadOnly;

		private final String key;

		private final String displayString;

		private final String taskKey;

		public String getDisplayString() {
			return displayString;
		}

		public boolean isHidden() {
			return isHidden;
		}

		public boolean isReadOnly() {
			return isReadOnly;
		}

		public String getKey() {
			return key;
		}

		public String getTaskKey() {
			return taskKey;
		}

		FogBugzAttribute(String taskKey, String displayString) {
			this(taskKey, displayString, taskKey, true, false);
		}

		FogBugzAttribute(String key, String displayString, String taskKey) {
			this(key, displayString, taskKey, false, false);
		}

		FogBugzAttribute(String key, String displayString, String taskKey,
				boolean hidden) {
			this(key, displayString, taskKey, hidden, false);
		}

		FogBugzAttribute(String key, String displayString, String taskKey,
				boolean hidden, boolean readonly) {
			this.key = key;
			this.displayString = displayString;
			this.taskKey = taskKey;
			this.isHidden = hidden;
			this.isReadOnly = readonly;
			attributeByFogBugzKey.put(key, this);
			if (taskKey != null) {
				fogBugzKeyByTaskKey.put(taskKey, key);
			}
		}

		@Override
		public String toString() {
			return getDisplayString();
		}
	}

	private static Map<String, FogBugzAttribute> attributeByFogBugzKey = new HashMap<String, FogBugzAttribute>();

	private static Map<String, String> fogBugzKeyByTaskKey = new HashMap<String, String>();
	static {
		// make sure hash maps get initialized when class is loaded
		FogBugzAttribute.values();
	}

	@Override
	public String getName(String key) {
		FogBugzAttribute attribute = attributeByFogBugzKey.get(key);
		return (attribute != null) ? attribute.toString() : key;
	}

	@Override
	public boolean isHidden(String key) {
		if (isInternalAttribute(key)) {
			return true;
		}
		FogBugzAttribute attribute = attributeByFogBugzKey.get(key);
		return (attribute != null) ? attribute.isHidden() : false;
	}

	static boolean isInternalAttribute(String id) {
		return RepositoryTaskAttribute.COMMENT_NEW.equals(id)
				|| RepositoryTaskAttribute.REMOVE_CC.equals(id)
				|| RepositoryTaskAttribute.NEW_CC.equals(id)
				|| RepositoryTaskAttribute.ADD_SELF_CC.equals(id);
	}

	@Override
	public boolean isReadOnly(String key) {
		FogBugzAttribute attribute = attributeByFogBugzKey.get(key);
		return (attribute != null) ? attribute.isReadOnly() : false;

	}

	public static final String TYPE_KEY = "type";

	@Override
	public String mapCommonAttributeKey(String key) {
		String fogBugzKey = fogBugzKeyByTaskKey.get(key);
		return (fogBugzKey != null) ? fogBugzKey : key;
	}

	@Override
	public Date getDateForAttributeType(String attributeKey, String dateString) {
		try {
			SimpleDateFormat f = new SimpleDateFormat();
			if (attributeKey != null
					&& attributeKey.equals(FogBugzAttribute.DUE_DATE.getKey()))
				f = new SimpleDateFormat(FogBugzConstants.DATE_PATTERN);
			Date d = f.parse(dateString);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
