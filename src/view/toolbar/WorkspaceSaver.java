package view.toolbar;

import controller.workspace.WorkspaceManager;
import javafx.scene.control.MenuItem;
import view.WorkspaceEditor;

public class WorkspaceSaver extends MenuElement implements WorkspaceEditor{
    private static final String NAME = "Save Workspace";

    private MenuItem myMenuItem;

    public WorkspaceSaver() {
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
