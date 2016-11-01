package view.toolbar;

import controller.workspace.WorkspaceManager;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

public class WorkspaceCreator extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "New Workspace";

    private MenuItem myMenuItem;

    public WorkspaceCreator() {
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
