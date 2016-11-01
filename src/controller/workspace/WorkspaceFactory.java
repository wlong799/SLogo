package controller.workspace;

import dataStorage.TurtleStorage;
import model.SLogoModel;
import view.WorkspaceContent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class WorkspaceFactory {
    private static final String FILE_NAME = "File";
    private static final String VIEW_NAME = "View";
    private static final String HELP_NAME = "Help";
    private static final String TOOLBAR_PACKAGE = "view.toolbar.";
    private static final String[] FILE_MENU_ELEMENTS = new String[]
            {
                    "WorkspaceCreator",
                    "WorkspaceLoader",
                    "WorkspaceSaver",
                    "WorkspaceSwitcher",
                    "WorkspaceCloser"
            };
    private static final String[] VIEW_MENU_ELEMENTS = new String[]
            {
                    "BackgroundColorPicker",
                    "SeparatorElement",
                    "LineColorPicker",
                    "LineSizePicker",
                    "LineStylePicker",
                    "SeparatorElement",
                    "TurtleImagePicker"
            };

    private static final String[] HELP_MENU_ELEMENTS = new String[]
            {
                    "AboutInfo",
                    "CommandHelpInfo",
                    "AdvancedCommandHelpInfo"
            };
    private static int nextWorkspaceID = 1;

    public static Workspace createWorkspace(double width, double height) {
        WorkspaceContent workspaceContent = new WorkspaceContent(width, height);
        WorkspacePreferences preferences = new WorkspacePreferences();

        preferences.getOpenTabs().forEach(workspaceContent::addTab);

        List<String> list = new ArrayList<>();
        for (String s : FILE_MENU_ELEMENTS) {
            list.add(TOOLBAR_PACKAGE + s);
        }

        workspaceContent.addMenuElement(FILE_NAME, Arrays.stream(FILE_MENU_ELEMENTS).map(
                s -> TOOLBAR_PACKAGE + s).toArray(size -> new String[size]));
        workspaceContent.addMenuElement(VIEW_NAME, Arrays.stream(VIEW_MENU_ELEMENTS).map(
                s -> TOOLBAR_PACKAGE + s).toArray(size -> new String[size]));
        workspaceContent.addMenuElement(HELP_NAME, Arrays.stream(HELP_MENU_ELEMENTS).map(
                s -> TOOLBAR_PACKAGE + s).toArray(size -> new String[size]));

        SLogoModel model = new SLogoModel();
        
        Workspace workspace = new Workspace(workspaceContent, model);
        TurtleStorage turtleStorage = model.getTurtles();
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < preferences.getNumTurtles(); i++) {
            idList.add(i);
        }
        turtleStorage.setActiveTurtles(idList);
        nextWorkspaceID++;
        return workspace;
    }

}
