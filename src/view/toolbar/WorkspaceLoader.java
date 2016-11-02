package view.toolbar;

import controller.SLogoController;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

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
