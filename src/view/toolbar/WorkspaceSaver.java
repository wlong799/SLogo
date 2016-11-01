package view.toolbar;

import controller.workspace.WorkspaceManager;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

public class WorkspaceSaver extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "Save Workspace";

    private MenuItem myMenuItem;

    public WorkspaceSaver() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public void setWorkspaceInteractions(WorkspaceManager workspaceManager) {
        return;
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
