package com.bugclipse.fogbugz.core;

import java.util.Date;

import org.eclipse.mylyn.tasks.core.AbstractTask;

import com.bugclipse.fogbugz.api.Case;
import com.bugclipse.fogbugz.api.client.FogBugzClient;

public class FogBugzTask extends AbstractTask {

	Case fogBugzCase;

	public FogBugzTask(String repositoryUrl, String id, String label) {
		super(repositoryUrl, id, label);
		setUrl(repositoryUrl + FogBugzConstants.URL_TASK + id);
	}

	public FogBugzTask(String repositoryUrl, Case c, FogBugzClient client) {
		super(repositoryUrl, c.getIxBug() + "", c.getSTitle());
		this.setCreationDate(new Date());
		fogBugzCase = c;
		setUrl(repositoryUrl + FogBugzConstants.URL_TASK + c.getIxBug());
		updateTaskFromCase(repositoryUrl, this, c);
	}

	@Override
	public String getConnectorKind() {
		return FogBugzCorePlugin.REPOSITORY_KIND;
	}

	@Override
	public boolean isLocal() {
		return false;
	}

	public Case getFogBugzCase() {
		return fogBugzCase;
	}

	@Override
	public void setPriority(String p) {
		String priority = p;
		if (p.equals("1"))
			priority = "P1";
		if (p.equals("2"))
			priority = "P2";
		if (p.equals("3"))
			priority = "P3";
		if (p.equals("4"))
			priority = "P3";
		if (p.equals("5"))
			priority = "P4";
		if (p.equals("6"))
			priority = "P4";
		if (p.equals("7"))
			priority = "P5";
		super.setPriority(priority);
	}

	public static void updateTaskFromCase(String repositoryUrl,
			AbstractTask task, Case c) {
		task.setUrl(repositoryUrl + FogBugzConstants.URL_TASK + c.getIxBug());
		task.setSummary(c.getSTitle());
		task.setOwner(c.getSPersonAssignedTo());
		task.setPriority(c.getIxPriority() + "");
		task.setTaskKind(c.getSCategory());
		task.setCreationDate(c.getDtOpened());
		task.setDueDate(c.getDtDue());
	}
}
