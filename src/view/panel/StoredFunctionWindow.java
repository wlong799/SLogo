package view.panel;

public class StoredFunctionWindow extends TabElement {
    private static final String MY_NAME = "Functions";

    public StoredFunctionWindow(double width, double height) {
        super(width, height);
    }

    @Override
    public String getTabName() {
        return MY_NAME;
    }
}