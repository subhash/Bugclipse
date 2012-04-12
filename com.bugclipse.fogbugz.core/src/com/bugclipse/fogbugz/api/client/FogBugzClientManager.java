package com.bugclipse.fogbugz.api.client;

import java.util.HashMap;

import org.eclipse.mylyn.internal.tasks.ui.editors.TaskUrlHyperlink;
import org.eclipse.mylyn.tasks.core.ITaskRepositoryListener;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUiPlugin;

public class FogBugzClientManager implements ITaskRepositoryListener {

	private HashMap<String, FogBugzClient> clientByUrl = new HashMap<String, FogBugzClient>();

	public FogBugzClientManager() {
		TasksUiPlugin.getRepositoryManager().addListener(this);
	}

	public FogBugzClient getClient(TaskRepository repository) {
		FogBugzClient client = clientByUrl.get(repository.getUrl());
		if (client == null) {
			client = FogBugzClientFactory.createClient(repository.getUrl(),
					repository.getUserName(), repository.getPassword(),
					repository.getProxy());
			clientByUrl.put(repository.getUrl(), client);
		}
		return client;
	}

	public FogBugzClient getClient(String repositoryUrl) {
		FogBugzClient client = clientByUrl.get(repositoryUrl);
		if (client == null) {
			TaskRepository repository = TasksUiPlugin.getRepositoryManager()
					.getRepository(repositoryUrl);
			client = FogBugzClientFactory.createClient(repository.getUrl(),
					repository.getUserName(), repository.getPassword(),
					repository.getProxy());
			clientByUrl.put(repository.getUrl(), client);
		}
		return client;
	}

	public void repositoriesRead() {
	}

	public void repositoryAdded(TaskRepository r) {
	}

	public void repositoryRemoved(TaskRepository r) {
		this.clientByUrl.remove(r.getUrl());
	}

	public void repositorySettingsChanged(TaskRepository r) {
		FogBugzClient client = this.getClient(r);
		if (client != null) {
			client.updateCredentials(r.getUserName(), r.getPassword(), r
					.getProxy());
			;
		}
	}

}
