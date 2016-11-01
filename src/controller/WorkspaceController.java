package controller;

import controller.workspace.WorkspaceManager;
import view.ElementManager;
import view.toolbar.WorkspaceCreator;

import java.util.Arrays;

/**
 * Sets up interactions between elements of view and elements in workspace
 */
public class WorkspaceController extends InteractionController {
    private static final String[] WORKSPACE_INTERACTOR_LIST = new String[]
            {
                    "WorkspaceCreator",
                    "WorkspaceLoader",
                    "WorkspaceSaver",
                    "WorkspaceSwitcher",
                    "WorkspaceCloser"
            };


    private WorkspaceManager myWorkspaceManager;

    public WorkspaceController(ElementManager elementManager, WorkspaceManager workspaceManager) {
        super(elementManager);
        myWorkspaceManager = workspaceManager;
    }

    @Override
    public void setUpInteractions() {
        Arrays.stream(WORKSPACE_INTERACTOR_LIST).map(className -> myViewElements.getWorkspaceInteractorElement(className)).filter(
                workspaceInteractor -> workspaceInteractor != null).forEach(
                workspaceInteractor -> workspaceInteractor.setWorkspaceInteractions(myWorkspaceManager));
    }
}
