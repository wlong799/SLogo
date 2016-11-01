package view.toolbar;

import controller.workspace.WorkspaceManager;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

public class WorkspaceLoader extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "Load Workspace";

    private MenuItem myMenuItem;

    public WorkspaceLoader() {
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
