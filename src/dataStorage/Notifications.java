package dataStorage;

import java.util.Observable;


public class Notifications extends Observable {
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    private Boolean myClearScreenFlag;

    private void updateAndCallObserver () {
        setChanged();
        notifyObservers(myClearScreenFlag);
    }

    public void setClearScreenFlag () {
        ////System.out.println("set clear screene flag");
        myClearScreenFlag = TRUE;
        updateAndCallObserver();
        myClearScreenFlag = FALSE;
    }
}
