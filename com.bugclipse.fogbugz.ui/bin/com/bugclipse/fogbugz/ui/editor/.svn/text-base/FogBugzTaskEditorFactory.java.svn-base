package com.bugclipse.fogbugz.ui.editor;

import org.eclipse.mylyn.tasks.core.AbstractTask;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUiPlugin;
import org.eclipse.mylyn.tasks.ui.editors.AbstractTaskEditorFactory;
import org.eclipse.mylyn.tasks.ui.editors.RepositoryTaskEditorInput;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditor;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

import com.bugclipse.fogbugz.core.FogBugzCorePlugin;
import com.bugclipse.fogbugz.core.FogBugzTask;

public class FogBugzTaskEditorFactory extends AbstractTaskEditorFactory {

	@Override
	public boolean canCreateEditorFor(AbstractTask task) {
		return task instanceof FogBugzTask;
	}

	@Override
	public boolean canCreateEditorFor(IEditorInput input) {
		if (input instanceof RepositoryTaskEditorInput) {
			RepositoryTaskEditorInput in = (RepositoryTaskEditorInput) input;
			boolean b = in.getTaskData() != null
					&& FogBugzCorePlugin.REPOSITORY_KIND.equals(in
							.getRepository().getConnectorKind());
			return b;
		}
		return false;
	}

	@Override
	public IEditorPart createEditor(TaskEditor parentEditor,
			IEditorInput editorInput) {
		if (editorInput instanceof RepositoryTaskEditorInput) {
			RepositoryTaskEditorInput taskInput = (RepositoryTaskEditorInput) editorInput;
			if (taskInput.getTaskData().isNew()) {
				return new NewFogbugzTaskEditor(parentEditor);
			} else {
				return new FogBugzTaskEditor(parentEditor);
			}
		} else if (editorInput instanceof TaskEditorInput) {
			return new FogBugzTaskEditor(parentEditor);
		}
		return null;
	}

	@Override
	public boolean providesOutline() {
		return true;
	}

	@Override
	public IEditorInput createEditorInput(AbstractTask task) {
		if (task instanceof FogBugzTask) {
			FogBugzTask fogBugzTask = (FogBugzTask) task;
			final TaskRepository repository = TasksUiPlugin
					.getRepositoryManager().getRepository(
							FogBugzCorePlugin.REPOSITORY_KIND,
							fogBugzTask.getRepositoryUrl());
//			 FogBugzTaskEditorInput input = new FogBugzTaskEditorInput(
//			 repository, fogBugzTask, false);
			 RepositoryTaskEditorInput input = new RepositoryTaskEditorInput(
					repository, fogBugzTask.getTaskId(), fogBugzTask.getUrl());
			return input;
		}
		return null;
	}

	@Override
	public String getTitle() {
		return "FogBugz";
	}

}
