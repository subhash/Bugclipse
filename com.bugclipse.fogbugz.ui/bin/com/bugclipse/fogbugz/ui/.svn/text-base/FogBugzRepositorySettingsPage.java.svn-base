package com.bugclipse.fogbugz.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.AbstractRepositoryConnectorUi;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.swt.widgets.Composite;

import com.bugclipse.fogbugz.api.client.FogBugzClient;
import com.bugclipse.fogbugz.api.client.FogBugzClientFactory;

public class FogBugzRepositorySettingsPage extends
		AbstractRepositorySettingsPage {

	private static final String TITLE = "FogBugz Repository Settings";

	private static final String DESCRIPTION = "Example: http://try.fogbugz.com/FogBugz";

	public FogBugzRepositorySettingsPage(
			AbstractRepositoryConnectorUi repositoryUi) {
		super(TITLE, DESCRIPTION, repositoryUi);
	}

	@Override
	protected void createAdditionalControls(Composite parent) {
	}

	@Override
	protected Validator getValidator(TaskRepository repository) {
		return new FogBugzValidator(repository);
	}

	@Override
	protected boolean isValidUrl(String name) {
		if ((name.startsWith(URL_PREFIX_HTTPS) || name
				.startsWith(URL_PREFIX_HTTP))
				&& !name.endsWith("/")) {
			try {
				new URL(name);
				return true;
			} catch (MalformedURLException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public void updateProperties(TaskRepository repository) {
//		repository
//				.setProperty(WebRepositoryConnector.PROPERTY_LOGIN_REQUEST_URL,
//						"${serverUrl}/default.asp?sPerson=${userId}&sPassword=${password}&pre=preLogon");
	}

	class FogBugzValidator extends Validator {

		private FogBugzClient client;

		public FogBugzValidator(TaskRepository r) {
			this.client = FogBugzClientFactory.createClient(r.getUrl(), r
					.getUserName(), r.getPassword(), r.getProxy());
		}

		@Override
		public void run(IProgressMonitor monitor) throws CoreException {
			try {
				this.client.login();
				setStatus(Status.OK_STATUS);
			} catch (Exception e) {
				e.printStackTrace();
				String message = "Repository cannot be contacted. Please check credentials";
				setStatus(new Status(Status.ERROR, "FogBugzUIPlugin", 1,
						message, e));
			}
		}
	}

}
