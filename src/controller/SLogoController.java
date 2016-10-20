package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.CommandParser;
import model.command.*;


public class SLogoController {

    private CommandParser myCommandParser;

    public SLogoController () {
        myCommandParser = new CommandParser("English");

    }

    public void parseText (String[] text) {

        for (String s : text) {

            if (s.trim().length() > 0) {

                try {
                    System.out.println(myCommandParser.parse(s));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        System.out.println();
    }
}
