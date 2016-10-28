package dataStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class TurtleStorage extends Observable implements Observer {

    private HashMap<Integer, Turtle> turtleMap;
    private List<Turtle> activeTurtles;

    public TurtleStorage () {
        turtleMap = new HashMap<Integer, Turtle>();
        activeTurtles = new ArrayList<Turtle>();
        Turtle t = new Turtle(0);
        t.addObserver(this);
        activeTurtles.add(t);
    }

    public void setActiveTurtles (List<Integer> ids) {
        activeTurtles.clear();
        for (int id : ids) {
            if (turtleMap.containsKey(id)) {
                activeTurtles.add(turtleMap.get(id));
            }
            else {
                Turtle t = new Turtle(id);
                turtleMap.put(id, t);
                activeTurtles.add(t);
            }
        }
        for (Turtle t : activeTurtles) {
            setChanged();
            notifyObservers(new TurtleState(t));
        }
    }

    public List<Turtle> getActiveTurtles () {
        return activeTurtles;
    }

    public Turtle getTurtle (int id) {
        return turtleMap.get(id);
    }

    @Override
    public void update (Observable o, Object arg) {
        System.out.println("CHANGED");
        System.out.println(o);
        System.out.println(arg);
        setChanged();
        notifyObservers(arg);
    }
}
