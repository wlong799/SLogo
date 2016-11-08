package view.toolbar;

import controller.SLogoController;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

/**
 * Menu element to load in a new workspace from preference file.
 *
 * @author Will Long
 */
public class WorkspaceLoader extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "Load Workspace";

    private MenuItem myMenuItem;

    public WorkspaceLoader() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public void setWorkspaceInteractions(SLogoController slogoController) {
        myMenuItem.setOnAction(event -> slogoController.loadWorkspace());
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
