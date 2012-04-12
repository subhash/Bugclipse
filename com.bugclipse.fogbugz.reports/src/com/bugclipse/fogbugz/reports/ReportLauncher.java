package com.bugclipse.fogbugz.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.framework.Bundle;

import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.reports.engine.ReportsEnginePlugin;

public class ReportLauncher {

	private static String enginePath, reportPath;

	private static IReportEngine engine;

	public static void runReport(Map<String, Object> scriptable,
			String reportFilename, String filename, String format,
			IProgressMonitor monitor) throws FogBugzClientException {
		try {
			monitor.subTask("Starting report engine");
			ReportLauncher.initReportEngine(reportFilename);
			monitor.worked(1);
			if (monitor.isCanceled())
				return;

			monitor.subTask("Opening report");
			FileInputStream fs = new FileInputStream(reportPath);
			IReportRunnable design = engine.openReportDesign(fs);
			IRunAndRenderTask task = engine.createRunAndRenderTask(design);
			monitor.worked(1);
			if (monitor.isCanceled())
				return;

			monitor.subTask("Rendering report");
			// Set rendering options - such as file or stream output,
			// output format, whether it is embeddable, etc
			HTMLRenderOption options;
			options = new HTMLRenderOption();
			options.setOutputFileName(filename);
			options.setOutputFormat(format);
			task.setRenderOption(options);
			for (Entry<String, Object> entry : scriptable.entrySet()) {
				task.addScriptableJavaObject(entry.getKey(), entry.getValue());
			}

			// run the report and destroy the engine

			task.run();
			task.close();
			engine.destroy();
			monitor.worked(1);
			if (monitor.isCanceled())
				return;
		} catch (FileNotFoundException e) {
			throw new FogBugzClientException("Missing report file: "
					+ e.getMessage(), e);
		} catch (EngineException e) {
			throw new FogBugzClientException("Exception in reporting engine: "
					+ e.getMessage(), e);
		}

	}

	public static void initReportEngine(String reportFilename)
			throws FogBugzClientException {
		try {
			System.out.println("Initing report engine");

			Bundle libBundle = ReportsEnginePlugin.getDefault().getBundle();
			URL engineURL = libBundle.getEntry("/");
			enginePath = new File(FileLocator.toFileURL(engineURL).getFile())
					.getAbsolutePath();

			Bundle reportsBundle = Activator.getDefault().getBundle();
			URL reportURL = reportsBundle.getEntry("reports/" + reportFilename);
			reportPath = new File(FileLocator.toFileURL(reportURL).getFile())
					.getAbsolutePath();

			EngineConfig config = new EngineConfig();
			config.setBIRTHome(enginePath);
			Platform.startup(config);

			// Create the report engine
			IReportEngineFactory factory = (IReportEngineFactory) Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			engine = factory.createReportEngine(config);
		} catch (IOException e) {
			throw new FogBugzClientException(
					"Error in reporting framework: Missing: " + e.getMessage(),
					e);
		} catch (BirtException e) {
			throw new FogBugzClientException("Error in reporting engine", e);
		}

	}

	private static void testReportRun() throws Exception {
		String reportFilename = "reports/YourReport.rptdesign";

		enginePath = "../com.bugclipse.fogbugz.reports.lib/";
		reportPath = reportFilename;

		EngineConfig config = new EngineConfig();
		config.setBIRTHome(enginePath);
		Platform.startup(config);

		// Create the report engine
		IReportEngineFactory factory = (IReportEngineFactory) Platform
				.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		engine = factory.createReportEngine(config);

		FileInputStream fs = new FileInputStream(reportPath);
		IReportRunnable design = engine.openReportDesign(fs);
		IRunAndRenderTask task = engine.createRunAndRenderTask(design);
		HTMLRenderOption options;
		options = new HTMLRenderOption();
		String filename = "c:/temp/see.html";
		options.setOutputFileName(filename);
		options.setOutputFormat("html");
		task.setRenderOption(options);
		Map<String, Object> scriptable = new HashMap<String, Object>();
		scriptable.put("customers", new Customer[] {
				new Customer("id1", "f1", "l1", "p1"),
				new Customer("id2", "f2", "l2", "p2") });
		scriptable.put("showColumns", Arrays.asList(new String[] { "id",
				"first", "phone" }));
		for (Entry<String, Object> entry : scriptable.entrySet()) {
			task.addScriptableJavaObject(entry.getKey(), entry.getValue());
		}
		task.run();
		task.close();
		engine.destroy();

	}

	private static class Customer {
		private String id, first, last, phone;

		public Customer(String id, String first, String last, String name) {
			super();
			this.id = id;
			this.first = first;
			this.last = last;
			this.phone = name;
		}

		public String getFirst() {
			return first;
		}

		public String getId() {
			return id;
		}

		public String getLast() {
			return last;
		}

		public String getPhone() {
			return phone;
		}
	}

	public static void main(String[] args) throws Exception {
		testReportRun();
	}

}
