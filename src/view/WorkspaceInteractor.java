package view;

import controller.SLogoController;

/**
 * Classes that implement this interface are able to edit the workspaces in the application.
 *
 * @author Will Long
 */
public interface WorkspaceInteractor {
    /**
     * Set the manner in which this class interacts with the workspaces.
     *
     * @param slogoController is the controller that holds the workspaces to interact with.
     */
    void setWorkspaceInteractions(SLogoController slogoController);
}
