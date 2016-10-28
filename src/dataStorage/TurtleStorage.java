package dataStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TurtleStorage {

    private HashMap<Integer, Turtle> turtleMap;
    private List<Turtle> activeTurtles;

    public TurtleStorage () {
        turtleMap = new HashMap<Integer, Turtle>();
        activeTurtles = new ArrayList<Turtle>();
        activeTurtles.add(new Turtle(0));
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
    }
    
    public List<Turtle> getActiveTurtles () {
        return activeTurtles;
    }
    
    public Turtle getTurtle(int id){
        return turtleMap.get(id);
    }
}
