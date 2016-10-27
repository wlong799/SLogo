package view.element;

public class CommandHistoryWindow extends TabElement {
    private static final String MY_NAME = "History";

    public CommandHistoryWindow(double width, double height) {
        super(width, height);
    }

    @Override
    public String getTabName() {
        return MY_NAME;
    }
}
