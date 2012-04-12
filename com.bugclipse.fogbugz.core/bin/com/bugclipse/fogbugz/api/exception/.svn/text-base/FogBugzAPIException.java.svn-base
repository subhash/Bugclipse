package com.bugclipse.fogbugz.api.exception;

import com.bugclipse.fogbugz.api.Error;

public class FogBugzAPIException extends FogBugzClientException {

	private Error error;

	public FogBugzAPIException(Error e) {
		super(e.getContent());
		this.error = e;
	}

	public Error getError() {
		return error;
	}

}
