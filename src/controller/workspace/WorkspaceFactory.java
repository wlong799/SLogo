package controller.workspace;

import model.SLogoModel;
import view.ContentManager;
import view.WorkspaceContent;

public class WorkspaceFactory {
    private static int nextWorkspaceID = 1;

    public static Workspace createWorkspace(double width, double height) {
        ContentManager contentManager = new WorkspaceContent(width, height);
        SLogoModel model = new SLogoModel();
        Workspace workspace = new Workspace(contentManager, model);
        nextWorkspaceID++;
        return workspace;
    }

}
