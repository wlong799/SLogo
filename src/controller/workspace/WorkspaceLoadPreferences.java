package controller.workspace;

import java.util.List;
import java.util.Map;

/**
 * @author Filip Mazurek
 */
public class WorkspaceLoadPreferences {


    private List<Integer> myBackgroundColor;
    private List<Integer> myLineColor;
    private String myStartImage;
    private String myCommandLanguage;

    public WorkspaceLoadPreferences(List<Integer> backgroundColor, List<Integer> lineColor,
                                    String startImage, String commandLanguage) {
        myBackgroundColor = backgroundColor;
        myLineColor = lineColor;
        myStartImage = startImage;
        myCommandLanguage = commandLanguage;
    }

    public List<Integer> getBackgroundColor() {
        return myBackgroundColor;
    }

    public List<Integer> getLineColor() {
        return myLineColor;
    }

    public String getStartImage() {
        return myStartImage;
    }

    public String getCommandLanguage() {
        return myCommandLanguage;
    }

}
