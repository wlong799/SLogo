package view.turtle;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import view.GUIElement;
import view.Style;
import view.Stylizable;

public class TurtleLines extends GUIElement implements Stylizable {
    private static final Color DEFAULT_LINE_COLOR = Color.BLACK;

    private Canvas myLineCanvas;
    private GraphicsContext myLineGraphics;

    public TurtleLines(double width, double height) {
        super(width, height);
        myLineCanvas = new Canvas(myWidth, myHeight);
        myLineGraphics = myLineCanvas.getGraphicsContext2D();
        myLineGraphics.setStroke(DEFAULT_LINE_COLOR);
    }

    @Override
    public void setStyle(Style style) {
        Color color = style.getColor();
        if (color != null) {
            myLineGraphics.setStroke(color);
        }
    }

    @Override
    public Node getContent() {
        return myLineCanvas;
    }

    public void animateLine(double x1, double y1, double x2, double y2, double timeMillis) {
        if (Math.abs(x1 - x2) < 1 && Math.abs(y1 - y2) < 1) {
            return;
        }
        DoubleProperty x = new SimpleDoubleProperty();
        DoubleProperty y = new SimpleDoubleProperty();

        AnimationTimer timer = new AnimationTimer() {
            double prevX = x1;
            double prevY = y1;

            @Override
            public void handle(long now) {
                myLineGraphics.strokeLine(prevX + (myWidth / 2), prevY + myHeight / 2,
                        x.get() + myWidth / 2, y.get() + myHeight / 2);
                prevX = x.get();
                prevY = y.get();
            }
        };

        EventHandler onFinished = event -> timer.stop();
        KeyFrame startFrame = new KeyFrame(Duration.millis(0),
                new KeyValue(x, x1),
                new KeyValue(y, y1));
        KeyFrame endFrame = new KeyFrame(Duration.millis(timeMillis),
                onFinished,
                new KeyValue(x, x2),
                new KeyValue(y, y2));

        Timeline timeline = new Timeline(startFrame, endFrame);

        timeline.play();
        timer.start();
    }
}
