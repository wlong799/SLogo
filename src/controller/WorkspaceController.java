package controller;

import view.ElementManager;

import java.util.Arrays;

/**
 * Sets up interactions between elements of view and elements in workspace
 */
public class WorkspaceController extends InteractionController {
    private static final String[] WORKSPACE_INTERACTOR_LIST = new String[]
            {
                    "StartButtons",
                    "WorkspaceCreator",
                    "WorkspaceLoader",
                    "WorkspaceVariableSaver",
                    "WorkspaceSwitcher",
                    "WorkspaceCloser"
            };


    private SLogoController mySlogoController;

    public WorkspaceController(ElementManager elementManager, SLogoController slogoController) {
        super(elementManager);
        mySlogoController = slogoController;
    }

    @Override
    public void setUpInteractions() {
        Arrays.stream(WORKSPACE_INTERACTOR_LIST).map(className -> myViewElements.getWorkspaceInteractorElement(className)).filter(
                workspaceInteractor -> workspaceInteractor != null).forEach(
                workspaceInteractor -> workspaceInteractor.setWorkspaceInteractions(mySlogoController));
    }
}
