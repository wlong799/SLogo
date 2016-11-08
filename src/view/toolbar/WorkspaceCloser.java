package view.toolbar;

import controller.SLogoController;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

/**
 * Menu element for closing a workspace.
 *
 * @author Will Long
 */
public class WorkspaceCloser extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "Close Workspace";

    private MenuItem myMenuItem;

    public WorkspaceCloser() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public void setWorkspaceInteractions(SLogoController slogoController) {
        myMenuItem.setOnAction(event -> slogoController.removeWorkspace());
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
