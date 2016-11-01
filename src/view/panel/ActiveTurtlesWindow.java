package view.panel;

public class ActiveTurtlesWindow extends TabElement {
	
	private static final String MY_NAME = "Turtles";
	
	public ActiveTurtlesWindow(double width, double height) {
        super(width, height);
    }

    @Override
    public String getTabName() {
        return MY_NAME;
    }
}
