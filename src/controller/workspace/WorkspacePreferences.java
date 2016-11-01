package controller.workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Responsible for loading the initial preferences of a workspace.
 */
public class WorkspacePreferences {
    private static final int DEFAULT_TURTLES = 1;
    private static final String VIEW_ELEMENT_PACKAGE_PREFIX = "view.panel.";
    private static final String[] DEFAULT_OPEN_TABS =
            {
                    "CommandHistoryWindow",
                    "StoredFunctionWindow",
                    "StoredVariableWindow",
                    "ActiveTurtlesWindow"
            };

    private List<String> myOpenTabs;
    private int myNumTurtles;

    public WorkspacePreferences() {
        myOpenTabs = new ArrayList<>();
        for (String className : DEFAULT_OPEN_TABS) {
            myOpenTabs.add(VIEW_ELEMENT_PACKAGE_PREFIX + className);
        }
        myNumTurtles = DEFAULT_TURTLES;
    }

    public List<String> getOpenTabs() {
        return myOpenTabs;
    }

    public int getNumTurtles() {
        return myNumTurtles;
    }
}
