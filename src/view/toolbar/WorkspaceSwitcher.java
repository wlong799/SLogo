package view.toolbar;

import controller.SLogoController;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

public class WorkspaceSwitcher extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "Switch Workspace";

    private MenuItem myMenuItem;

    public WorkspaceSwitcher() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public void setWorkspaceInteractions(SLogoController slogoController) {
        return;
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
