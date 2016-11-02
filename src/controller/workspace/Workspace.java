package controller.workspace;

import controller.SLogoController;
import controller.ViewModelController;
import controller.ViewViewController;
import controller.WorkspaceController;
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
    }

    public ContentManager getContentManager() {
        return myContent;
    }

    public SLogoModel getModel() {
        return myModel;
    }
}
