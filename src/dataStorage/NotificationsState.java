package dataStorage;


public class NotificationsState {
    private boolean myClearScreenFlag;
    private boolean myBackgroundColorFlag;
    private int myBackgroundColorIndex;
    private boolean myFileSavedFlag;

    NotificationsState(boolean clearScreenFlag, boolean backgroundColorFlag, int backgroundColorIndex,
                              boolean fileSavedFlag) {
        myClearScreenFlag = clearScreenFlag;
        myBackgroundColorFlag = backgroundColorFlag;
        myBackgroundColorIndex = backgroundColorIndex;
        myFileSavedFlag = fileSavedFlag;
    }

    public boolean getClearScreenFlag() {
        return myClearScreenFlag;
    }

    public boolean getBackgroundColorFlag() {
        return myBackgroundColorFlag;
    }

    public int getBackgroundColorIndex() {
        return myBackgroundColorIndex;
    }

    public boolean getFileSavedFlag() {
        return myFileSavedFlag;
    }

}
