package dataStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class TurtleStorage extends Observable implements Observer {

    private HashMap<Integer, Turtle> turtleMap;
    private ObservableList<Integer> activeTurtles;

    public TurtleStorage () {
        turtleMap = new HashMap<Integer, Turtle>();
        activeTurtles = FXCollections.observableArrayList();
        Turtle t = new Turtle(0);
        t.addObserver(this);
        activeTurtles.add(0);
        turtleMap.put(0, t);
    }

    public void setActiveTurtles (List<Integer> ids) {
        activeTurtles.clear();
        System.out.println("Active turtles cleared. Active turtles = " + activeTurtles);
        for (int id : ids) {
            System.out.println("Adding turtle " + id + " to active");
            if (turtleMap.containsKey(id)) {
                activeTurtles.add(id);
            }
            else {
                Turtle t = new Turtle(id);
                turtleMap.put(id, t);
                activeTurtles.add(id);
            }
        }
        updateTurtles();
    }

    private void updateTurtles () {
        for (int i : activeTurtles) {
            setChanged();
            notifyObservers(new TurtleState(turtleMap.get(i)));
        }
    }

    public List<Turtle> getActiveTurtles () {
        List<Turtle> turtles = new ArrayList<Turtle>();
        for (int i : activeTurtles) {
            turtles.add(turtleMap.get(i));
        }
        return turtles;
    }

    public ObservableList<Integer> getActiveTurtleIDs () {
        return activeTurtles;
    }

    public Turtle getTurtle (int id) {
        return turtleMap.get(id);
    }

    @Override
    public void update (Observable o, Object arg) {
        System.out.println("CHANGED");
        System.out.println(o);
        TurtleState state = (TurtleState) arg;
        System.out.println(state.getPosition());
        setChanged();
        notifyObservers(arg);
    }
}
