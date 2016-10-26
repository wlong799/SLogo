package controller;

import controller.workspace.Workspace;
import controller.workspace.WorkspaceManager;
import view.SLogoView;
import model.SLogoModel;
import view.SLogoView;
import model.SLogoModel;
import view.StartContent;
import view.WorkspaceContent;


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
        myWorkspaceManager.addWorkspace();
        mySLogoView.setCurrentContentManager(myWorkspaceManager.getCurrentWorkspace().getContentManager());
    }


    private void launchStartScreen() {
        double width = mySLogoView.getWidth();
        double height = mySLogoView.getHeight();
        mySLogoView.setCurrentContentManager(new StartContent(width, height));
        StartController startController = new StartController(mySLogoView.getViewElements(), this);
        startController.setUpInteractions();
    }

}
