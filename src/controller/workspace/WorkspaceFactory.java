package controller.workspace;

import controller.SLogoController;
import controller.ViewModelController;
import controller.ViewViewController;
import controller.WorkspaceController;
import dataStorage.TurtleStorage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.SLogoModel;
import view.ElementManager;
import view.StartContent;
import view.Style;
import view.WorkspaceContent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WorkspaceFactory {
    private static final String TOOLBAR_PACKAGE = "view.toolbar.";
    private static final String PANEL_PACKAGE = "view.panel.";
    private static final int NUM_TURTLES = 1;
    private static final String FILE_NAME = "File";
    private static final String VIEW_NAME = "View";
    private static final String ANIMATION_NAME = "Animation";
    private static final String HELP_NAME = "Help";
    private static final String[] FILE_MENU_ELEMENTS = new String[]
            {
                    "WorkspaceCreator",
                    "WorkspaceLoader",
                    "WorkspaceSwitcher",
                    "SeparatorElement",
                    "WorkspaceVariableSaver",
                    "WorkspaceVariableLoader",
                    "SeparatorElement",
                    "WorkspaceCloser"
            };
    private static final String[] VIEW_MENU_ELEMENTS = new String[]
            {
                    "BackgroundColorPicker",
                    "SeparatorElement",
                    "LineColorPicker",
                    "LineSizePicker",
                    "LineStylePicker",
                    "PenDownToggle",
                    "SeparatorElement",
                    "TurtleImagePicker",
                    "CustomTurtleImageInput"
            };
    private static final String[] ANIMATION_MENU_ELEMENTS = new String[]
            {
                    "AnimationToggler",
                    "RunSpeedSetter",
                    "AnimationStepper"
            };

    private static final String[] HELP_MENU_ELEMENTS = new String[]
            {
                    "LanguageChooser",
                    "SeparatorElement",
                    "AboutInfo",
                    "CommandHelpInfo"

            };
    private static final String[] TAB_ELEMENTS =
            {
                    "CommandHistoryWindow",
                    "StoredFunctionWindow",
                    "StoredVariableWindow",
                    "PaletteWindow",
                    "ActiveTurtlesWindow"
            };

    public static Workspace createWorkspace(double width, double height, SLogoController slogoController, boolean isStartType) {
        if (isStartType) {
            return createStartContent(width, height, slogoController);
        }
        WorkspaceContent workspaceContent = new WorkspaceContent(width, height);

        workspaceContent.addMenuElement(FILE_NAME, Arrays.stream(FILE_MENU_ELEMENTS).map(
                s -> TOOLBAR_PACKAGE + s).toArray(size -> new String[size]));
        workspaceContent.addMenuElement(VIEW_NAME, Arrays.stream(VIEW_MENU_ELEMENTS).map(
                s -> TOOLBAR_PACKAGE + s).toArray(size -> new String[size]));
        workspaceContent.addMenuElement(ANIMATION_NAME, Arrays.stream(ANIMATION_MENU_ELEMENTS).map(
                s -> TOOLBAR_PACKAGE + s).toArray(size -> new String[size]));
        workspaceContent.addMenuElement(HELP_NAME, Arrays.stream(HELP_MENU_ELEMENTS).map(
                s -> TOOLBAR_PACKAGE + s).toArray(size -> new String[size]));

        Arrays.stream(TAB_ELEMENTS).map(baseClass -> PANEL_PACKAGE + baseClass)
                .forEach(className -> workspaceContent.addTab(className));

        SLogoModel model = new SLogoModel();
        new ViewViewController(workspaceContent.getElements()).setUpInteractions();
        new ViewModelController(workspaceContent.getElements(), model).setUpInteractions();
        new WorkspaceController(workspaceContent.getElements(), slogoController)
                .setUpInteractions();

        Workspace workspace = new Workspace(workspaceContent, model);
        TurtleStorage turtleStorage = model.getTurtles();
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < NUM_TURTLES; i++) {
            idList.add(i);
        }
        turtleStorage.setActiveTurtles(idList);
        return workspace;
    }

    public static Workspace createWorkspace(double width,
                                            double height,
                                            SLogoController controller,
                                            WorkspaceLoadPreferences preferences) {
        Workspace workspace = createWorkspace(width, height, controller, false);
        ElementManager viewElements = workspace.getContentManager().getElements();

        List<Integer> rgb = preferences.getBackgroundColor();
        Color bgColor = new Color(rgb.get(0) / 255., rgb.get(1) / 255., rgb.get(2) / 255., 1.0);
        viewElements.getStylizableElement("TurtleContainer").setStyle(new Style(bgColor));

        rgb = preferences.getLineColor();
        Color lineColor =
                new Color(rgb.get(0) / 255.0, rgb.get(1) / 255.0, rgb.get(2) / 255.0, 1.0);
        viewElements.getStylizableElement("TurtleManager").setStyle(new Style(lineColor));

        Image startImage = new Image(preferences.getStartImage());
        viewElements.getStylizableElement("TurtleManager").setStyle(new Style(startImage));

        workspace.getModel().setLanguage(preferences.getCommandLanguage());
        return workspace;
    }

    private static Workspace createStartContent(double width,
                                                double height,
                                                SLogoController slogoController) {
        StartContent startContent = new StartContent(width, height);
        new WorkspaceController(startContent.getElements(), slogoController).setUpInteractions();
        return new Workspace(startContent, null);
    }
}
