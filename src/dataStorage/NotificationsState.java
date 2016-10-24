package dataStorage;


public class NotificationsState {
    private boolean myClearScreenFlag;
    private boolean mySyntaxErrorFlag;

    public NotificationsState(boolean clearScreenFlag, boolean syntaxErrorFlag) {
        myClearScreenFlag = clearScreenFlag;
        mySyntaxErrorFlag = syntaxErrorFlag;
    }

    public boolean getClearScreenFlag() {
        return myClearScreenFlag;
    }

    public boolean getSyntaxErrorFlag() {
        return mySyntaxErrorFlag;
    }

}
