package controller;

import controller.workspace.Workspace;
import controller.workspace.WorkspaceManager;
import view.*;
import model.SLogoModel;
import view.SLogoView;
import model.SLogoModel;


public class SLogoController {
    private static final String DEFAULT_LANGUAGE = "English";

    private WorkspaceManager myWorkspaceManager;
    private SLogoView mySLogoView;

    public SLogoController(double width, double height) {
        mySLogoView = new SLogoView(width, height);
        myWorkspaceManager = new WorkspaceManager(mySLogoView);

        launchStartScreen();
    }

    public SLogoView getSLogoView() {
        return mySLogoView;
    }

    public void createNewWorkspace() {
        double width = mySLogoView.getWidth();
        double height = mySLogoView.getHeight();
        ContentManager content = new WorkspaceContent(width, height);
        Workspace workspace = new Workspace(content, new SLogoModel());
        myWorkspaceManager.addWorkspace(workspace);
    }

    public void loadCurrentWorkspace() {
        Workspace currentWorkspace = myWorkspaceManager.getCurrentWorkspace();
        if (currentWorkspace == null) {
            launchStartScreen();
        } else {
            mySLogoView.setCurrentContentManager(currentWorkspace.getContentManager());
        }
    }

    private void launchStartScreen() {
        double width = mySLogoView.getWidth();
        double height = mySLogoView.getHeight();
        mySLogoView.setCurrentContentManager(new StartContent(width, height));
        StartController startController = new StartController(mySLogoView.getViewElements(), this);
        startController.setUpInteractions();
    }

}
