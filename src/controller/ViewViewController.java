package controller;

import view.element.ViewElement;

import java.util.List;

public class ViewViewController extends InteractionController {

    protected ViewViewController(List<ViewElement> elements) {
        super(elements);
    }

    @Override
    public void setUpInteractions() {
        return;
    }
}
