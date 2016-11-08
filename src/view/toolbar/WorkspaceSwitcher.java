package view.toolbar;

import controller.SLogoController;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import view.WorkspaceInteractor;

import java.util.HashMap;
import java.util.Map;

/**
 * Menu element that provides a updating list of all available workspaces, and switches to the one clicked on.
 *
 * @author Will Long
 */
public class WorkspaceSwitcher extends MenuElement implements WorkspaceInteractor {
    private static final String NAME = "Switch Workspace";
    private static final String WORKSPACE_PREFIX = "Workspace ";

    private Menu myMenu;
    private ToggleGroup myToggleGroup;
    private Map<Integer, RadioMenuItem> myCurrentItems;

    public WorkspaceSwitcher() {
        myMenu = new Menu(NAME);
        myToggleGroup = new ToggleGroup();
        myCurrentItems = new HashMap<>();
    }

    /**
     * Toggle group and menu with radio buttons allow for the user to select the current workspace. Available buttons
     * automatically updates as workspaces are opened and closed.
     *
     * @param slogoController is the controller that holds the workspaces to interact with.
     */
    @Override
    public void setWorkspaceInteractions(SLogoController slogoController) {
        slogoController.getActiveWorkspaceNums().addListener((ListChangeListener<? super Integer>) c -> {
            myMenu.getItems().clear();
            myToggleGroup.getToggles().removeAll();
            myCurrentItems.clear();
            while (c.next()) {
                c.getList().stream().forEach(num -> {
                    RadioMenuItem menuItem = new RadioMenuItem(WORKSPACE_PREFIX + num);
                    menuItem.setUserData(num);
                    myCurrentItems.put(num, menuItem);
                    menuItem.setToggleGroup(myToggleGroup);
                    myMenu.getItems().add(menuItem);
                });
            }
        });
        myToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (myToggleGroup.getSelectedToggle() != null) {
                int selectedWorkspace = (Integer) myToggleGroup.getSelectedToggle().getUserData();
                if (selectedWorkspace == slogoController.getCurrentWorkspaceNum().get()) {
                    return;
                }
                slogoController.setCurrentWorkspaceNum(selectedWorkspace);
            }
        });
        slogoController.getCurrentWorkspaceNum().addListener((observable, oldValue, newValue) -> {
            myCurrentItems.get(newValue).setSelected(true);
        });
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenu;
    }
}
