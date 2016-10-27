package controller.workspace;

import model.SLogoModel;
import view.ContentManager;
import view.SLogoView;
import view.StartContent;
import view.WorkspaceContent;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the various workspaces available in the application
 */
public class WorkspaceManager {
    private int currentWorkspaceNum;
    private int maxWorkspaceNum;
    private int numWorkspaces;
    private Map<Integer, Workspace> workspaceMap;

    public WorkspaceManager() {
        currentWorkspaceNum = -1;
        maxWorkspaceNum = 0;
        numWorkspaces = 0;
        workspaceMap = new HashMap<>();
    }

    public void addWorkspace(Workspace workspace) {
        numWorkspaces++;
        maxWorkspaceNum++;
        currentWorkspaceNum = maxWorkspaceNum;
        workspaceMap.put(currentWorkspaceNum, workspace);
    }

    public Workspace getCurrentWorkspace() {
        if (numWorkspaces == 0 || currentWorkspaceNum <= 0 || !workspaceMap.containsKey(currentWorkspaceNum)) {
            return null;
        }
        return  workspaceMap.get(currentWorkspaceNum);
    }
}
