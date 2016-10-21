package controller;

import dataStorage.DataStorageManager;
import model.CommandParser;
import view.SLogoView;
import model.SLogoModel;


public class SLogoController {
    private static final String DEFAULT_LANGUAGE = "English";

    private SLogoModel myModel;
    private SLogoView mySLogoView;

    public SLogoController () {
        myModel = new SLogoModel(DEFAULT_LANGUAGE);
        mySLogoView = new SLogoView();
        setUpInteractions();
    }

    public SLogoView getSLogoView () {
        return mySLogoView;
    }

    private void setUpInteractions () {
        ViewModelController vmController = new ViewModelController(mySLogoView.getViewElements());
        vmController.setModel(myModel);
        vmController.setUpInteractions();
    }
}
