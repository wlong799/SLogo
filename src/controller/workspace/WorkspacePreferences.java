package controller.workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Responsible for loading the initial preferences of a workspace.
 */
public class WorkspacePreferences {
    private static final String VIEW_ELEMENT_PACKAGE_PREFIX = "view.element.";
    private static final String[] DEFAULT_OPEN_TABS =
            {"CommandHistoryWindow",
                    "StoredFunctionWindow",
                    "StoredVariableWindow"};

    private List<String> myOpenTabs;

    public WorkspacePreferences() {
        myOpenTabs = new ArrayList<>();
        for (String className : DEFAULT_OPEN_TABS) {
            myOpenTabs.add(VIEW_ELEMENT_PACKAGE_PREFIX + className);
        }
    }

    public List<String> getOpenTabs() {
        return myOpenTabs;
    }
}
