package controller;

import controller.workspace.Workspace;
import controller.workspace.WorkspaceFactory;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.SLogoView;

import java.util.*;


public class SLogoController {
    private SLogoView mySLogoView;
    private int myNextWorkspaceNum;
    private Stack<Integer> myPrevWorkspaceNumStack;
    private SimpleIntegerProperty myCurrentWorkspaceNum;
    private Map<Integer, Workspace> myWorkspaceMap;
    private ObservableList<Integer> myActiveWorkspaceNums;

    public SLogoController(double width, double height) {
        mySLogoView = new SLogoView(width, height);
        myWorkspaceMap = new HashMap<>();
        myActiveWorkspaceNums = FXCollections.observableArrayList();
        myPrevWorkspaceNumStack = new Stack<>();
        myCurrentWorkspaceNum = new SimpleIntegerProperty();
        launchStartScreen();
    }

    public SLogoView getSLogoView() {
        return mySLogoView;
    }

    private void launchStartScreen() {
        myCurrentWorkspaceNum.set(-1);
        myPrevWorkspaceNumStack.clear();
        myWorkspaceMap.clear();
        myActiveWorkspaceNums.clear();
        myNextWorkspaceNum = 1;
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

    public void removeWorkspace() {
        myActiveWorkspaceNums.remove(new Integer(myCurrentWorkspaceNum.get()));
        myWorkspaceMap.remove(myCurrentWorkspaceNum.get());
        while(!myPrevWorkspaceNumStack.empty()) {
            int num = myPrevWorkspaceNumStack.pop();
            if (myWorkspaceMap.containsKey(num)) {
                setCurrentWorkspaceNum(num);
                return;
            }
        }
        System.exit(0);
    }

    public SimpleIntegerProperty getCurrentWorkspaceNum() {
        return myCurrentWorkspaceNum;
    }

    public void setCurrentWorkspaceNum(int num) {
        if (!myWorkspaceMap.containsKey(num)) {
            if (num == -1) {
                launchStartScreen();
            }
            return;
        }
        System.out.println("SETTING TO " + num);
        myPrevWorkspaceNumStack.push(myCurrentWorkspaceNum.get());
        myCurrentWorkspaceNum.set(num);
        System.out.println("PREVIOUS " + myPrevWorkspaceNumStack);
        System.out.println("CURRENT " + myCurrentWorkspaceNum);
        Workspace workspace = myWorkspaceMap.get(num);
        mySLogoView.setCurrentContentManager(workspace.getContentManager());
    }

    public ObservableList<Integer> getActiveWorkspaceNums() {
        return myActiveWorkspaceNums;
    }
}
