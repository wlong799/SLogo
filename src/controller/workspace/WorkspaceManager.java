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
    private SLogoView mySLogoView;
    private int currentWorkspaceNum;
    private int maxWorkspaceNum;
    private int numWorkspaces;
    private Map<Integer, Workspace> workspaceMap;

    public WorkspaceManager(SLogoView sLogoView) {
        mySLogoView = sLogoView;
        currentWorkspaceNum = -1;
        maxWorkspaceNum = 0;
        numWorkspaces = 0;
        workspaceMap = new HashMap<>();
    }

    public void addWorkspace() {
        numWorkspaces++;
        maxWorkspaceNum++;
        currentWorkspaceNum = maxWorkspaceNum;
        ContentManager content = new WorkspaceContent(mySLogoView.getWidth(), mySLogoView.getHeight());
        Workspace workspace = new Workspace(content, new SLogoModel());
        workspaceMap.put(currentWorkspaceNum, workspace);
    }

    public Workspace getCurrentWorkspace() {
        if (numWorkspaces == 0 || currentWorkspaceNum <= 0 || !workspaceMap.containsKey(currentWorkspaceNum)) {
            return null;
        }
        return  workspaceMap.get(currentWorkspaceNum);
    }
}
