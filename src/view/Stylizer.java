package view;

/**
 * Stylizer classes can send Style information to Stylizable classes in order to change their appearance.
 */
public interface Stylizer {
    /**
     * Set the target object that Stylizer should send Style info to when triggered.
     *
     * @param stylizableTarget is a Stylizable class to set appearance of.
     */
    void setStylizableTarget(Stylizable stylizableTarget);
}
