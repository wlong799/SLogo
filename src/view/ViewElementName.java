package view;

/**
 * Holds names of the various ViewElement classes for more flexible type checking
 */
public enum ViewElementName {
    TURTLE_VIEW("TurtleView"),
    TEXT_ENTRY_BOX("TextEntryBox");

    private String myName;

    ViewElementName(String name) {
        myName = name;
    }

    public String getName() {
        return myName;
    }
}
