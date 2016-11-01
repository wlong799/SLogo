package dataStorage;


public class NotificationsState {
    private boolean myClearScreenFlag;
    private boolean myBackgroundColorFlag;
    private int myBackgroundColorIndex;

    public NotificationsState(boolean clearScreenFlag, boolean backgroundColorFlag, int backgroundColorIndex) {
        myClearScreenFlag = clearScreenFlag;
        myBackgroundColorFlag = backgroundColorFlag;
        myBackgroundColorIndex = backgroundColorIndex;
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

}
