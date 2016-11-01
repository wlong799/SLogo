package view.toolbar;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import view.Style;
import view.Stylizable;
import view.Stylizer;

public class LineSizePicker extends MenuElement implements Stylizer{
    private static final String NAME = "Change Line Size";
    private static final double Default_Size = 1.0; 
   
    private MenuItem myMenuItem;
    private Slider mySizeSlider;
    

    public LineSizePicker () {
    	SliderCreator();
        myMenuItem = new MenuItem(NAME, mySizeSlider);
    }
    
    private void SliderCreator(){
    	mySizeSlider = new Slider(0,20.0, Default_Size);
    	mySizeSlider.setShowTickLabels(true);
    	mySizeSlider.setShowTickMarks(true);
    	mySizeSlider.setSnapToTicks(true);
    	mySizeSlider.setMajorTickUnit(10);
    	mySizeSlider.setBlockIncrement(2);
    }

    @Override
    public MenuItem getMenuItem () {
        return myMenuItem;
    }

    @Override
    public void setStylizableTarget(Stylizable stylizableTarget) {
    	mySizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				double lineWidth = mySizeSlider.getValue();
                Style style = new Style(lineWidth);
                stylizableTarget.setStyle(style);
				}
            });
            
        }
    
    }

