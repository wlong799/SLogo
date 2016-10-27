package controller.workspace;

import model.SLogoModel;
import view.ContentManager;
import view.WorkspaceContent;

public class WorkspaceFactory {
    private static int nextWorkspaceID = 1;

    public static Workspace createWorkspace(double width, double height) {
        WorkspaceContent workspaceContent = new WorkspaceContent(width, height);
        WorkspacePreferences preferences = new WorkspacePreferences();
        workspaceContent.addTabs(preferences.getOpenTabs());
        SLogoModel model = new SLogoModel();
        Workspace workspace = new Workspace(workspaceContent, model);
        nextWorkspaceID++;
        return workspace;
    }

}
