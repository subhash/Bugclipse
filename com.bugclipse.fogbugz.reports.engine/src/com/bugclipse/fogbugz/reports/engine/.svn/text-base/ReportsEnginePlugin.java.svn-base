package com.bugclipse.fogbugz.reports.engine;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ReportsEnginePlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.bugclipse.fogbugz.reports.engine";

	// The shared instance
	private static ReportsEnginePlugin plugin;
	
	/**
	 * The constructor
	 */
	public ReportsEnginePlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
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
	public static ReportsEnginePlugin getDefault() {
		return plugin;
	}

}
