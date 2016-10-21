package controller;

import dataStorage.Turtle;
import model.CommandParser;
import view.element.TextEntryBox;
import view.element.TurtleView;
import view.element.ViewElement;

import java.util.List;

public class ViewModelController extends InteractionController {
    private Turtle myTurtle;
    private CommandParser myCommandParser;

    protected ViewModelController(List<ViewElement> elements) {
        super(elements);
    }

    @Override
    public void setUpInteractions() {
        linkTextBoxToParser();
        linkTurtleWithView();
    }

    public void setTurtle(Turtle turtle) {
        myTurtle = turtle;
    }

    public void setCommandParser(CommandParser parser) {
        myCommandParser = parser;
    }

    private void linkTurtleWithView() {
        if (myTurtle == null || getElementByClass("TurtleView") == null) {
            return;
        }
        TurtleView turtleView = (TurtleView)getElementByClass("TurtleView");
        myTurtle.addObserver(turtleView);
        myTurtle.setVisibility(true);
    }

    private void linkTextBoxToParser() {
        if (myCommandParser == null || getElementByClass("TextEntryBox") == null) {
            return;
        }
        TextEntryBox textEntryBox = (TextEntryBox) getElementByClass("TextEntryBox");
        textEntryBox.setSubmitHandler(event -> {
            String entryText = textEntryBox.getEnteredText();
            if (entryText == null || entryText.trim().length() == 0) {
                return;
            }
            for (String line : entryText.split("\n")) {
                line = line.trim();
                if (line.length() > 0) {
                    try {
                        myCommandParser.parse(line, myTurtle);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
