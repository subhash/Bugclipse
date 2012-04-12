package com.bugclipse.fogbugz.api.client;

import java.net.Proxy;

public class FogBugzClientFactory {

	public static FogBugzClient createClient(String url, String username,
			String password, Proxy proxy) {
		return new FogBugzClient(url, username, password, proxy);
	}

}
