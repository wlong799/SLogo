package controller;

import dataStorage.Turtle;
import model.CommandParser;
import model.SLogoModel;
import view.element.TextEntryBox;
import view.element.TurtleView;
import view.element.ViewElement;

import java.util.List;

public class ViewModelController extends InteractionController {
    private SLogoModel myModel;

    protected ViewModelController(List<ViewElement> elements) {
        super(elements);
    }

    @Override
    public void setUpInteractions() {
        linkTextBoxToParser();
        linkTurtleWithView();
    }

    public void setModel(SLogoModel model){
        myModel = model;
    }


    private void linkTurtleWithView() {
        Turtle turtle = myModel.getTurtle();
        if (turtle == null || getElementByClass("TurtleView") == null) {
            return;
        }
        TurtleView turtleView = (TurtleView)getElementByClass("TurtleView");
        turtle.addObserver(turtleView);
        turtle.setVisibility(true);
    }

    private void linkTextBoxToParser() {
        if (myModel.noParser() || getElementByClass("TextEntryBox") == null) {
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
                        myModel.parse(line);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
