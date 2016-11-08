package view.toolbar;

import controller.SLogoController;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

/**
 * Menu element for creating a new workspace.
 *
 * @author Will Long
 */
public class WorkspaceCreator extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "New Workspace";

    private MenuItem myMenuItem;

    public WorkspaceCreator() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public void setWorkspaceInteractions(SLogoController slogoController) {
        myMenuItem.setOnAction(event -> slogoController.newWorkspace());
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
