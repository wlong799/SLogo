package controller;

import view.SLogoView;
import model.SLogoModel;
import view.SLogoView;
import model.SLogoModel;
import view.StartContent;
import view.WorkspaceContent;


public class SLogoController {
    private static final String DEFAULT_LANGUAGE = "English";

    private SLogoModel myModel;
    private SLogoView mySLogoView;

    public SLogoController () {
        myModel = new SLogoModel(DEFAULT_LANGUAGE);
        mySLogoView = new SLogoView();

        StartController startController = new StartController(mySLogoView.getViewElements(), this);
        startController.setUpInteractions();
    }

    public SLogoView getSLogoView () {
        return mySLogoView;
    }

    private void setUpInteractions () {
        ViewModelController vmController = new ViewModelController(mySLogoView.getViewElements());
        vmController.setModel(myModel);
        vmController.setUpInteractions();

        ViewViewController vvController = new ViewViewController(mySLogoView.getViewElements());
        vvController.setUpInteractions();
    }

    public void newWorkspace() {
        mySLogoView.setCurrentContentManager(new WorkspaceContent());
        setUpInteractions();
    }

}
