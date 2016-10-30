package view;

import controller.workspace.WorkspaceManager;

/**
 * Classes that implement this interface are able to edit the workspaces in the application.
 */
public interface WorkspaceEditor {
    void setWorkspaceManager(WorkspaceManager manager);
}
