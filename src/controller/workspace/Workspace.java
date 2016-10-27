package controller.workspace;

import controller.ViewModelController;
import controller.ViewViewController;
import model.SLogoModel;
import view.ContentManager;

/**
 * Responsible for maintaining the separate View and Model elements of an individual workspace.
 */
public class Workspace {
    private ContentManager myContent;
    private SLogoModel myModel;

    public Workspace(ContentManager content, SLogoModel model) {
        myContent = content;
        myModel = model;
        setUpInteractions();
    }

    public ContentManager getContentManager() {
        return myContent;
    }

    private void setUpInteractions() {
        ViewModelController vmController = new ViewModelController(myContent.getElements(), myModel);
        vmController.setUpInteractions();

        ViewViewController vvController = new ViewViewController(myContent.getElements());
        vvController.setUpInteractions();
    }

}
