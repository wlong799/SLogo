package controller;

import view.ElementManager;

import java.util.Arrays;

/**
 * Sets up interactions for elements that can manage the current workspaces in the application.
 *
 * @author Will Long
 */
public class WorkspaceController extends InteractionController {
    private SLogoController mySlogoController;

    public WorkspaceController(ElementManager elementManager, SLogoController slogoController) {
        super(elementManager);
        mySlogoController = slogoController;
    }

    @Override
    public void setUpInteractions() {
        myViewElements.getWorkspaceInteractorElements().forEach(
                workspaceInteractor -> workspaceInteractor.setWorkspaceInteractions(mySlogoController));
    }
}
