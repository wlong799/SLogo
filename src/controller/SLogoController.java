package controller;

import controller.workspace.Workspace;
import view.SLogoView;
import model.SLogoModel;
import view.SLogoView;
import model.SLogoModel;
import view.StartContent;
import view.WorkspaceContent;


public class SLogoController {
    private static final String DEFAULT_LANGUAGE = "English";

    private double myWidth, myHeight;

    private Workspace myCurrentWorkspace;
    private SLogoView mySLogoView;

    public SLogoController(double width, double height) {
        myWidth = width;
        myHeight = height;
        mySLogoView = new SLogoView(myWidth, myHeight);

        launchStartScreen();

    }

    public SLogoView getSLogoView() {
        return mySLogoView;
    }

    public void newWorkspace() {
        myCurrentWorkspace = new Workspace(new WorkspaceContent(myWidth, myHeight), new SLogoModel());
        mySLogoView.setCurrentContentManager(myCurrentWorkspace.getContentManager());
    }


    private void launchStartScreen() {
        mySLogoView.setCurrentContentManager(new StartContent(myWidth, myHeight));
        StartController startController = new StartController(mySLogoView.getViewElements(), this);
        startController.setUpInteractions();
    }

}
