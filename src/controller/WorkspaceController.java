package controller;

import view.ElementManager;

import java.util.Arrays;

/**
 * Sets up interactions between elements of view and elements in workspace
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
