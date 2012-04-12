package com.bugclipse.fogbugz.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.tasks.core.RepositoryStatus;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.osgi.framework.BundleContext;

import com.bugclipse.fogbugz.api.exception.FogBugzLicenseException;

/**
 * The activator class controls the plug-in life cycle
 */
public class FogBugzCorePlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.bugclipse.fogbugz.core";

	public final static String REPOSITORY_KIND = "fogbugz";

	public final static String TASK_KIND = "Case";

	// The shared instance
	private static FogBugzCorePlugin plugin;

	/**
	 * The constructor
	 */
	public FogBugzCorePlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static FogBugzCorePlugin getDefault() {
		return plugin;
	}

	public static IStatus toStatus(Throwable e, TaskRepository repository) {
		if (e instanceof FogBugzLicenseException) {
			return new RepositoryStatus(repository.getUrl(), IStatus.ERROR,
					FogBugzCorePlugin.PLUGIN_ID,
					RepositoryStatus.ERROR_PERMISSION_DENIED,
					"License expired or is not valid");
		}
		// if (e instanceof TracLoginException) {
		// return RepositoryStatus.createLoginError(repository.getUrl(),
		// PLUGIN_ID);
		// } else if (e instanceof TracPermissionDeniedException) {
		// return TracStatus.createPermissionDeniedError(repository.getUrl(),
		// PLUGIN_ID);
		// } else if (e instanceof TracException) {
		// String message = e.getMessage();
		// if (message == null) {
		// message = "I/O error has occured";
		// }
		// return new RepositoryStatus(repository.getUrl(), Status.ERROR,
		// PLUGIN_ID, RepositoryStatus.ERROR_IO,
		// message, e);
		// } else if (e instanceof ClassCastException) {
		// return new RepositoryStatus(Status.ERROR, PLUGIN_ID,
		// RepositoryStatus.ERROR_IO,
		// "Unexpected server response: " + e.getMessage(), e);
		// } else if (e instanceof MalformedURLException) {
		// return new RepositoryStatus(Status.ERROR, PLUGIN_ID,
		// RepositoryStatus.ERROR_IO,
		// "Repository URL is invalid", e);
		// } else {
		return new RepositoryStatus(Status.ERROR, PLUGIN_ID,
				RepositoryStatus.ERROR_INTERNAL, "Unexpected error", e);
		// }
	}

}
