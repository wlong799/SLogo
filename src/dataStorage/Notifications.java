package dataStorage;

import java.util.Observable;


public class Notifications extends Observable {
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    private boolean myClearScreenFlag;

    private void updateAndCallObserver () {
        setChanged();
        notifyObservers(myClearScreenFlag);
    }

    public void setClearScreenFlag () {
        myClearScreenFlag = TRUE;
        updateAndCallObserver();
        myClearScreenFlag = FALSE;
    }
}
