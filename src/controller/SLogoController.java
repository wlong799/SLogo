package controller;

import controller.workspace.Workspace;
import controller.workspace.WorkspaceFactory;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.SimpleStyleableIntegerProperty;
import view.*;
import view.SLogoView;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;


public class SLogoController {
    private SLogoView mySLogoView;
    private int myNextWorkspaceNum;
    private SimpleIntegerProperty myCurrentWorkspaceNum;
    private Map<Integer, Workspace> myWorkspaceMap;
    private ObservableList<Integer> myActiveWorkspaceNums;

    public SLogoController(double width, double height) {
        mySLogoView = new SLogoView(width, height);
        myWorkspaceMap = new HashMap<>();
        myActiveWorkspaceNums = FXCollections.observableArrayList();
        myNextWorkspaceNum = 1;
        myCurrentWorkspaceNum = new SimpleIntegerProperty(-1);
    }

    public SLogoView getSLogoView() {
        return mySLogoView;
    }

    public void launchStartScreen() {
        double width = mySLogoView.getWidth();
        double height = mySLogoView.getHeight();
        Workspace workspace = WorkspaceFactory.createWorkspace(width, height, this, true);
        mySLogoView.setCurrentContentManager(workspace.getContentManager());
    }

    public void newWorkspace() {
        double width = mySLogoView.getWidth();
        double height = mySLogoView.getHeight();
        Workspace workspace = WorkspaceFactory.createWorkspace(width, height, this, false);
        myActiveWorkspaceNums.add(myNextWorkspaceNum);
        myWorkspaceMap.put(myNextWorkspaceNum, workspace);
        setCurrentWorkspaceNum(myNextWorkspaceNum);
        myNextWorkspaceNum++;
    }

    public SimpleIntegerProperty getCurrentWorkspaceNum() {
        return myCurrentWorkspaceNum;
    }

    public void setCurrentWorkspaceNum(int num) {
        if (!myWorkspaceMap.containsKey(num)) {
            return;
        }
        myCurrentWorkspaceNum.set(myNextWorkspaceNum);
        myCurrentWorkspaceNum.set(num);
        Workspace workspace = myWorkspaceMap.get(num);
        mySLogoView.setCurrentContentManager(workspace.getContentManager());
    }

    public ObservableList<Integer> getActiveWorkspaceNums() {
        return myActiveWorkspaceNums;
    }
}
