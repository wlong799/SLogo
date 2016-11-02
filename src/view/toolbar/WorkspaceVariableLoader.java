package view.toolbar;

import controller.SLogoController;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

public class WorkspaceVariableLoader extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "Load Workspace Variables";

    private MenuItem myMenuItem;

    public WorkspaceVariableLoader() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public void setWorkspaceInteractions(SLogoController slogoController) {
        myMenuItem.setOnAction(event -> slogoController.loadWorkspaceVariables());
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
