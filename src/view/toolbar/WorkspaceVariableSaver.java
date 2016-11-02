package view.toolbar;

import controller.SLogoController;
import javafx.scene.control.MenuItem;
import view.WorkspaceInteractor;

public class WorkspaceVariableSaver extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "Save Workspace Variables";

    private MenuItem myMenuItem;

    public WorkspaceVariableSaver() {
        myMenuItem = new MenuItem(NAME);
    }

    @Override
    public void setWorkspaceInteractions(SLogoController slogoController) {
        myMenuItem.setOnAction(event -> slogoController.saveWorkspaceVariables());
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
