package dataStorage;

import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * 
 * @author Michael Schroeder
 *
 */
public class TurtleStorage extends Observable implements Observer {

    private HashMap<Integer, Turtle> turtleMap;
    private ObservableList<Integer> activeTurtles;
    private List<TurtleState> changedTurtles;

    public TurtleStorage () {
        turtleMap = new HashMap<>();
        activeTurtles = FXCollections.observableArrayList();
        changedTurtles = new ArrayList<TurtleState>();
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
                t.addObserver(this);
                turtleMap.put(id, t);
                activeTurtles.add(id);
                t.setVisibility(true);
            }
        }
    }

    public List<Turtle> getActiveTurtles () {
        List<Turtle> turtles = new ArrayList<>();
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

    public Set<Integer> getAllTurtleIDs() {
        return turtleMap.keySet();
    }

    @Override
    public void update (Observable o, Object arg) {
        System.out.println("CHANGED");
        System.out.println(o);
        TurtleState state = (TurtleState) arg;
        System.out.println(state.getPosition());
        changedTurtles.add(state);
        // setChanged();
        // notifyObservers(arg);
    }

    public void updateTurtles () {
        setChanged();
        notifyObservers(changedTurtles);
        changedTurtles.clear();
    }
}
