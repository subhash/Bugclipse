package com.bugclipse.fogbugz.api.exception;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.mylyn.tasks.core.RepositoryStatus;
import org.eclipse.mylyn.tasks.core.TaskRepository;

import com.bugclipse.fogbugz.core.FogBugzCorePlugin;

public class FogBugzStatus {

	public static IStatus createClientErrorStatus(TaskRepository repository,
			FogBugzClientException e) {
		return new RepositoryStatus(repository.getUrl(), IStatus.ERROR,
				FogBugzCorePlugin.PLUGIN_ID, RepositoryStatus.ERROR_REPOSITORY,
				e.getMessage());
	}

	public static IStatus createIOErrorStatus(TaskRepository repository,
			IOException e) {
		return new RepositoryStatus(repository.getUrl(), IStatus.ERROR,
				FogBugzCorePlugin.PLUGIN_ID, RepositoryStatus.ERROR_IO, e
						.getMessage());
	}

}
