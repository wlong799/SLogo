package controller;

import model.CommandParser;
import view.SLogoView;


public class SLogoController {
    private static final String DEFAULT_LANGUAGE = "English";

    private CommandParser myCommandParser;
    private SLogoView mySLogoView;

    public SLogoController() {
        myCommandParser = new CommandParser(DEFAULT_LANGUAGE);
        mySLogoView = new SLogoView();
        setUpInteractions();
    }

    public SLogoView getSLogoView() {
        return mySLogoView;
    }

    private void setUpInteractions() {
        ViewModelController vmController = new ViewModelController(mySLogoView.getViewElements());
        vmController.setCommandParser(myCommandParser);
        vmController.setUpInteractions();
    }
}
