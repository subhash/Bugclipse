package com.bugclipse.fogbugz.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;

public class FogBugzImages {
	

	private static final URL baseURL = FogBugzUiPlugin.getDefault().getBundle().getEntry("/icons/");

	public static final String T_VIEW = "eview16";

	public static final ImageDescriptor OVERLAY_BUG = create(T_VIEW, "overlay-critical.gif");

	public static final ImageDescriptor OVERLAY_FEATURE = create(T_VIEW, "overlay-enhancement.gif");
	public static final ImageDescriptor OVERLAY_INQUIRY = create(T_VIEW, "overlay-major.gif");
	public static final ImageDescriptor OVERLAY_SCHEDULE_ITEM = create(T_VIEW, "overlay-normal.gif");

	private static ImageDescriptor create(String prefix, String name) {
		try {
			return ImageDescriptor.createFromURL(makeIconFileURL(prefix, name));
		} catch (MalformedURLException e) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}

	private static URL makeIconFileURL(String prefix, String name) throws MalformedURLException {
		if (baseURL == null)
			throw new MalformedURLException();

		StringBuffer buffer = new StringBuffer(prefix);
		if (prefix != "")
			buffer.append('/');
		buffer.append(name);
		return new URL(baseURL, buffer.toString());
	}


}
