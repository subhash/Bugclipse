package com.bugclipse.fogbugz.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.eclipse.mylyn.tasks.core.RepositoryTaskAttribute;

import com.bugclipse.fogbugz.api.Category;
import com.bugclipse.fogbugz.api.PersonContained;
import com.bugclipse.fogbugz.api.Priority;
import com.bugclipse.fogbugz.api.Project;
import com.bugclipse.fogbugz.api.client.FogBugzClient;
import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.core.FogBugzAttributeFactory.FogBugzAttribute;

public class FogBugzAttributeAdapter {

	private FogBugzClient client;

	public FogBugzAttributeAdapter(FogBugzClient client) {
		this.client = client;
	}

	public ArrayList<String> getOptions(FogBugzAttribute attribute)
			throws FogBugzClientException {
		ArrayList<String> options = new ArrayList<String>();
		if (attribute.equals(FogBugzAttribute.PROJECT)) {
			Project[] projects = client.getProjects();
			for (Project project : projects) {
				options.add(project.getSProject());
			}
		} else if (attribute.equals(FogBugzAttribute.PRIORITY)) {
			Priority[] priors = client.getPriorities();
			for (Priority priority : priors) {
				options.add(priority.getIxPriority() + " - "
						+ priority.getSPriority());
			}
		} else if (attribute.equals(FogBugzAttribute.CATEGORY)) {
			Category[] categories = client.getCategories();
			for (Category category : categories) {
				options.add(category.getSCategory());
			}
		} else if (attribute.equals(FogBugzAttribute.ASSIGNED_TO)) {
			PersonContained[] persons = client.getPeople();
			for (PersonContained contained : persons) {
				options.add(contained.getSFullName());
			}
		}
		return options;
	}

	public Map<String, String> getPriorityOptions()
			throws FogBugzClientException {
		HashMap<String, String> options = new HashMap<String, String>();
		Priority[] priors = client.getPriorities();
		for (Priority priority : priors) {
			options.put(priority.getIxPriority() + " - "
					+ priority.getSPriority(), priority.getIxPriority() + "");
		}
		return options;
	}

	public static String optionFromParam(RepositoryTaskAttribute attr,
			String param) {
		for (String opt : attr.getOptions()) {
			if (attr.getOptionParameter(opt).equals(param))
				return opt;
		}
		return null;
	}

	public static String toLocalTZFormat(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(FogBugzConstants.DATE_PATTERN);
		f.setTimeZone(TimeZone.getDefault());
		String dateString = f.format(date);
		return dateString;
	}

	public static Date toLocalTZDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(FogBugzConstants.DATE_PATTERN);
		f.setTimeZone(TimeZone.getDefault());
		String dateString = f.format(date);
		try {
			return f.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toUTCFormat(String value) throws ParseException {
		Date d = new SimpleDateFormat(FogBugzConstants.DATE_PATTERN)
				.parse(value);
		SimpleDateFormat f = new SimpleDateFormat(FogBugzConstants.UTC_PATTERN);
		f.setTimeZone(TimeZone.getTimeZone("UTC"));
		value = f.format(d);
		return value;
	}

	public static String toUTCFormat(Date date) {
		
		try {
			return toUTCFormat(new SimpleDateFormat(FogBugzConstants.DATE_PATTERN)
					.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return date.toGMTString();
		}
	}

}
