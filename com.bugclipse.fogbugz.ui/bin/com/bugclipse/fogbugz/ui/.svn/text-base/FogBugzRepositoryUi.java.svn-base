package com.bugclipse.fogbugz.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.mylyn.internal.tasks.ui.OpenRepositoryTaskJob;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryQuery;
import org.eclipse.mylyn.tasks.core.AbstractTask;
import org.eclipse.mylyn.tasks.core.RepositoryTaskData;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.TaskRepositoryManager;
import org.eclipse.mylyn.tasks.core.TaskSelection;
import org.eclipse.mylyn.tasks.ui.AbstractRepositoryConnectorUi;
import org.eclipse.mylyn.tasks.ui.TasksUiPlugin;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.mylyn.tasks.ui.wizards.NewTaskWizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.bugclipse.fogbugz.core.FogBugzCorePlugin;
import com.bugclipse.fogbugz.ui.search.FogBugzSearchPage;
import com.bugclipse.fogbugz.ui.wizard.NewFogBugzQueryWizard;

public class FogBugzRepositoryUi extends AbstractRepositoryConnectorUi {

	@Override
	public IWizard getQueryWizard(TaskRepository repository,
			AbstractRepositoryQuery queryToEdit) {
		if (queryToEdit == null)
			return new NewFogBugzQueryWizard(repository);
		else {
			System.out.println("returning null");
			return null;
		}
	}

	@Override
	public String getConnectorKind() {
		return FogBugzCorePlugin.REPOSITORY_KIND;
	}

	@Override
	public String getTaskKindLabel(AbstractTask arg0) {
		return FogBugzCorePlugin.TASK_KIND;
	}

	@Override
	public String getTaskKindLabel(RepositoryTaskData arg0) {
		return FogBugzCorePlugin.TASK_KIND;
	}

	@Override
	public ImageDescriptor getTaskKindOverlay(AbstractTask task) {
		String cat = task.getTaskKind();
		if (cat.equals("Feature"))
			return FogBugzImages.OVERLAY_FEATURE;
		if (cat.equals("Inquiry"))
			return FogBugzImages.OVERLAY_INQUIRY;
		if (cat.equals("Schedule Item"))
			return FogBugzImages.OVERLAY_SCHEDULE_ITEM;
		return super.getTaskKindOverlay(task);
	}

	@Override
	public IWizard getNewTaskWizard(TaskRepository taskRepository) {
		return new NewTaskWizard(taskRepository);
	}

	@Override
	public IWizard getNewTaskWizard(TaskRepository taskRepository,
			TaskSelection selection) {
		return new NewTaskWizard(taskRepository, selection);
	}

	@Override
	public AbstractRepositorySettingsPage getSettingsPage() {
		return new FogBugzRepositorySettingsPage(this);
	}

	@Override
	public boolean hasSearchPage() {
		return true;
	}

	@Override
	public WizardPage getSearchPage(TaskRepository repository,
			IStructuredSelection selection) {
		return new FogBugzSearchPage(repository);
	}

	@Override
	public boolean supportsDueDates(AbstractTask task) {
		return true;
	}

	@Override
	public boolean openRepositoryTask(String repositoryUrl, String id) {
		System.out
				.println("In open rep task - " + repositoryUrl + " --- " + id);
		TaskRepositoryManager repositoryManager = TasksUiPlugin
				.getRepositoryManager();
		AbstractRepositoryConnector connector = repositoryManager
				.getRepositoryConnector(getConnectorKind());
		String taskUrl = connector.getTaskUrl(repositoryUrl, id);
		System.out.println("Taskurl = " + taskUrl);
		if (taskUrl == null) {
			return false;
		}

		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window == null) {
			IWorkbenchWindow[] windows = PlatformUI.getWorkbench()
					.getWorkbenchWindows();
			if (windows != null && windows.length > 0) {
				window = windows[0];
			}
		}
		if (window == null) {
			return false;
		}
		IWorkbenchPage page = window.getActivePage();

		OpenRepositoryTaskJob job = new OpenRepositoryTaskJob(
				getConnectorKind(), repositoryUrl, id, taskUrl, page);
		job.schedule();

		return true;
	}

}
