package com.bugclipse.fogbugz.core;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.mylyn.tasks.core.AbstractAttachmentHandler;
import org.eclipse.mylyn.tasks.core.AbstractTask;
import org.eclipse.mylyn.tasks.core.ITaskAttachment;
import org.eclipse.mylyn.tasks.core.RepositoryAttachment;
import org.eclipse.mylyn.tasks.core.TaskRepository;

import com.bugclipse.fogbugz.api.exception.FogBugzClientException;
import com.bugclipse.fogbugz.api.exception.FogBugzStatus;

public class FogBugzAttachmentHandler extends AbstractAttachmentHandler {

	private FogBugzRepositoryConnector connector;

	public FogBugzAttachmentHandler(FogBugzRepositoryConnector connector) {
		this.connector = connector;
	}

	@Override
	public boolean canDeprecate(TaskRepository repository,
			RepositoryAttachment attachment) {
		return false;
	}

	@Override
	public boolean canDownloadAttachment(TaskRepository repository,
			AbstractTask task) {
		return true;
	}

	@Override
	public boolean canUploadAttachment(TaskRepository repository,
			AbstractTask task) {
		return true;
	}

	@Override
	public InputStream getAttachmentAsStream(TaskRepository repository,
			RepositoryAttachment attachment, IProgressMonitor monitor)
			throws CoreException {
		String url = attachment.getUrl().split(repository.getUrl() + "/")[1];
		try {
			return connector.getClientManager().getClient(repository)
					.downloadAttachment(url, monitor);
		} catch (FogBugzClientException e) {
			throw new CoreException(FogBugzStatus.createClientErrorStatus(
					repository, e));
		} catch (IOException e) {
			throw new CoreException(FogBugzStatus.createIOErrorStatus(
					repository, e));
		}
	}

	@Override
	public void updateAttachment(TaskRepository repository,
			RepositoryAttachment attachment) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void uploadAttachment(TaskRepository repository, AbstractTask task,
			ITaskAttachment attachment, String comment, IProgressMonitor monitor)
			throws CoreException {
		try {
			monitor.beginTask("Uploading attachment", monitor.UNKNOWN);
			String uploadComment = "Added attachment: "
					+ attachment.getFilename() + ", "
					+ attachment.getDescription() + "\n" + comment;
			connector.getClientManager().getClient(repository)
					.uploadAttachment(task.getTaskId(), attachment,
							uploadComment, monitor);
		} catch (FogBugzClientException e) {
			throw new CoreException(FogBugzStatus.createClientErrorStatus(
					repository, e));
		}

	}

}
