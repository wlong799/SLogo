package view.toolbar;

import controller.workspace.WorkspaceManager;
import javafx.scene.control.MenuItem;
import view.WorkspaceEditor;

public class WorkspaceSwitcher extends MenuElement implements WorkspaceEditor{
    private static final String NAME = "Switch Workspace";

    private MenuItem myMenuItem;

    public WorkspaceSwitcher() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public void setWorkspaceManager(WorkspaceManager manager) {
        return;
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
