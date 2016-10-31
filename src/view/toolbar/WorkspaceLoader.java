package view.toolbar;

import controller.workspace.WorkspaceManager;
import javafx.scene.control.MenuItem;
import view.WorkspaceEditor;

public class WorkspaceLoader extends MenuElement implements WorkspaceEditor{
    private static final String NAME = "Load Workspace";

    private MenuItem myMenuItem;

    public WorkspaceLoader() {
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
