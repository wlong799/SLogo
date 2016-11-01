package view;

import controller.SLogoController;

/**
 * Classes that implement this interface are able to edit the workspaces in the application.
 */
public interface WorkspaceInteractor {
    void setWorkspaceInteractions(SLogoController slogoController);
}
