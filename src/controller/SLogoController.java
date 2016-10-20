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
    }

    public void parseText(String[] text) {

        for (String s : text) {

            if (s.trim().length() > 0) {

                try {
                    System.out.println(myCommandParser.parse(s));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        System.out.println();
    }

    public SLogoView getSLogoView() {
        return mySLogoView;
    }
}
