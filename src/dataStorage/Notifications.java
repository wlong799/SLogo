package dataStorage;


import java.util.Observable;

public class Notifications extends Observable {
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    private boolean myClearScreenFlag;
    private boolean myBackgroundColorFlag;
    private int myBackgroundColorIndex;

    private void updateAndCallObserver() {
        NotificationsState showOffState = new NotificationsState(myClearScreenFlag, myBackgroundColorFlag,
                myBackgroundColorIndex);
        setChanged();
        notifyObservers(showOffState);
        // clearChanged(); // TODO: Was this removed on purpose?
    }

    public void setClearScreenFlag() {
        myClearScreenFlag = TRUE;
        updateAndCallObserver();
        myClearScreenFlag = FALSE;
    }

    public void setNewBackgroundColorIndex(int newIndex) {
        myBackgroundColorFlag = TRUE;
        myBackgroundColorIndex = newIndex;
        updateAndCallObserver();
        myBackgroundColorFlag = FALSE;
    }
}
