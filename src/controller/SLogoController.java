package controller;

import controller.workspace.Workspace;
import controller.workspace.WorkspaceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.*;
import view.SLogoView;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;


public class SLogoController {
    private SLogoView mySLogoView;
    private int myNextWorkspaceNum;
    private int myCurrentWorkspaceNum;
    private Map<Integer, Workspace> myWorkspaceMap;
    private ObservableList<Integer> myActiveWorkspaceNums;

    public SLogoController(double width, double height) {
        mySLogoView = new SLogoView(width, height);
        myWorkspaceMap = new HashMap<>();
        myActiveWorkspaceNums = FXCollections.observableArrayList();
        myNextWorkspaceNum = 1;
        myCurrentWorkspaceNum = -1;
    }

    public SLogoView getSLogoView() {
        return mySLogoView;
    }

    public void launchStartScreen() {
        double width = mySLogoView.getWidth();
        double height = mySLogoView.getHeight();
        Workspace workspace = WorkspaceFactory.createWorkspace(width, height, this, true);
        setCurrentWorkspace(workspace);
    }

    public void newWorkspace() {
        double width = mySLogoView.getWidth();
        double height = mySLogoView.getHeight();
        Workspace workspace = WorkspaceFactory.createWorkspace(width, height, this, false);
        myCurrentWorkspaceNum = myNextWorkspaceNum;
        myActiveWorkspaceNums.add(myCurrentWorkspaceNum);
        myWorkspaceMap.put(myCurrentWorkspaceNum, workspace);
        myNextWorkspaceNum++;
        setCurrentWorkspace(workspace);
    }

    private void setCurrentWorkspace(Workspace workspace) {
        mySLogoView.setCurrentContentManager(workspace.getContentManager());
    }
}
