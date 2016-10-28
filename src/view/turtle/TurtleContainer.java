package view.turtle;

import dataStorage.TurtleState;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GUIElement;

import java.util.Observable;
import java.util.Observer;

/**
 * Container for all current turtles and the lines they've drawn
 */
public class TurtleContainer extends GUIElement implements Observer {
    private static final Color DEFAULT_BG_COLOR = Color.WHITE;
    private static final Color DEFAULT_LINE_COLOR = Color.BLACK;
    private static final String TURTLE_IMAGE_LOCATION = "resources/turtle.png";
    private static final double TURTLE_SIZE = 50;

    private TurtleState prevState, currentState;
    private StackPane myContent;
    private Rectangle background;
    private Canvas lineCanvas;
    private GraphicsContext lineGraphics;
    private ImageView turtle;

    public TurtleContainer(double width, double height) {
        super(width, height);
        background = new Rectangle(width, height, DEFAULT_BG_COLOR);
        lineCanvas = new Canvas(width, height);
        lineGraphics = lineCanvas.getGraphicsContext2D();
        lineGraphics.setStroke(DEFAULT_LINE_COLOR);

        setTurtleImageInit(TURTLE_IMAGE_LOCATION);

        myContent = new StackPane();
        myContent.getChildren().addAll(background, lineCanvas, turtle);
    }

    @Override
    public Node getContent() {
        return myContent;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (currentState != null) {
            prevState = currentState;
        } else {
            prevState = (TurtleState) arg;
        }
        currentState = (TurtleState) arg;
        draw();
        return;
    }
    
    public void setTurtleImage(String picture_file_path){
    	
			turtle.setImage(new Image(picture_file_path));
			turtle.setFitHeight(TURTLE_SIZE);
			turtle.setFitWidth(TURTLE_SIZE);
		} 
    
    public void setTurtleImageInit(String picture_file_path){
    	
		turtle = new ImageView(new Image(picture_file_path));
		turtle.setFitHeight(TURTLE_SIZE);
		turtle.setFitWidth(TURTLE_SIZE);
	} 
    
    
    public void setBackgroundColor(Color color) {
        background.setFill(color);
    }
    
    public void setLineColor(Color color){
    	lineGraphics.setStroke(color);
    }

    private void draw() {
        double x1 = currentState.getPosition().getX();
        double y1 = currentState.getPosition().getY();
        double x2 = prevState.getPosition().getX();
        double y2 = prevState.getPosition().getY();
        if (x1 != x2 || y1 != y2) {
            updateTurtlePosition(x1, y1);
            if (currentState.getPenDownStatus()) {
                drawLine(x1, y1, x2, y2);
            }
        }

        updateTurtleHeading(currentState.getHeading());
        updateTurtleVisibility(currentState.getVisibility());
    }

    private void updateTurtlePosition(double x, double y) {
        turtle.setTranslateX(x);
        turtle.setTranslateY(y);
    }

    private void drawLine(double x1, double y1, double x2, double y2) {
        lineGraphics.strokeLine(x1 + myWidth / 2, y1 + myHeight / 2,
                x2 + myWidth / 2, y2 + myHeight / 2);
    }

    private void updateTurtleHeading(double heading) {
        turtle.setRotate(heading + 90);
    }
    

    private void updateTurtleVisibility(boolean isVisible) {
        turtle.setVisible(isVisible);
    }
}
