package view.toolbar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class FileMenu extends AbstractMenu {
    private static final String NAME = "File";

    public FileMenu() {
        myMenu = new Menu(NAME);
        MenuItem newWorkspace = new MenuItem("New Workspace");
        MenuItem loadWorkspace = new MenuItem("Load Workspace");
        MenuItem selectWorkspace = new MenuItem("Select Workspace");
        MenuItem saveWorkspace = new MenuItem("Save Workspace");
        MenuItem closeWorkspace = new MenuItem("Close Workspace");
        MenuItem exit = new MenuItem("Exit");
        myMenu.getItems().addAll(newWorkspace, loadWorkspace, selectWorkspace, saveWorkspace, closeWorkspace, exit);
    }
}
