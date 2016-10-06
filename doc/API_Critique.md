API Critique
============

AUTHORS:
Filip Mazurek, fjm7
Michael Schroeder, ms548
Will Long, wpl5
James Marlotte, jmm155

Simulation
----------
### Internal
#### Example Methods
* BackgroundCell (All Methods)
* Cell
  * public int getMyCol()
	* public int getMyRow()
	* public void initalizeState(Map<String, Integer> initialStates)
	* public String getCurrentType()
	* public int getCurrentState(String stateName)
  * public void stepToNextStateAndType()
	* public void setNextType(String cellType)
	* public void setNextState(String stateName, int stateVal)
* Rule
  * public void initialize(CellGrid myGrid, List<GameParameter> initialParameters)
  * public void evaluateGrid(CellGrid myGrid)
  * public void setParameter(String parameterName, int value)
* CellGrid
  * public void addItemsToGrid(int gridWidth, int gridHeight, List<String> initialCellTypes)
  * public int getGridWidth()
  * public int getGridHeight()
  * public List<Cell> getCellsByType(String cellType)
  * public Cell getCell(int row, int col)
  * abstract public List<Cell> getNeighbours(Cell myCell);
  * public void updateParameter(String param, int value)

#### Description
The internal API for simulation mostly consists of communication between the Rule, CellGrid, and Cell classes.
CellGrid contains all of the Cells in the simulation, and the Rule class is responsible for updating states of
each Cell.

### External
#### Example Methods
* public abstract void setColor(Cell myCell, CellGrid myGrid);
* public abstract Cell getVerticesAndMakeCell(String cellType, int row, int col, double cellXPos, double cellYPos);
* public Map<String, Double> getCellProportions()
* public double getDrawCellWidth()
* public double getDrawCellHeight()
* public void step()

#### Description
The external simulation API works to communicate what is happening to the simulation into the front end. By calling the `getCurrentType()`
and `getCurrentState(str)`, the front end can figure out what it needs to display. The front end can also call the step() method
to tell the back-end when to update the simulation.

Configuration
----------
### Internal
#### Example Methods
* public abstract void reset();
* public abstract void update() throws XMLGameInfoException;
* public abstract void parseInfo(String infoName, String infoValue);

#### Description
The internal API consists solely of communication between GameInfoHandler and the various classes that implement interface.
GameInfoHandler is responsible for determining which section of the XML document is being parsed, and then sending that
information to the correct parser.

### External
#### Example Methods
* public String getRuleClassName()
* public int getGridWidth()
* public String getGridTiling()
* public boolean isToroidal()

#### Description
The external methods for the configuartion allow the other parts of the simulation to decide how they need to set up. The method `getGridWidth()`
will allow the Grid class to find out what size to make itself. Similarly, the `getGridTiling()` allows the CellGrid class to know what
shapes it will need to work with to figure out neighbors as well as the rendering of the grid. The Simulation itself will get its
own necessary settings partly from `isToroidal()`.

Visualization
----------
### Internal
#### Example Methods
			CellTypeChart(...)
      getScene()
      InputPanel(...)


#### Description
Most of the gui methods are used internally to set up visual elements, Scene, etc..

### External
#### Example Methods
* public ParameterAdjustmentControl(...)

#### Description
The external visualization classes are the buttons and other user-interaction elements that communicate with the simlulation backend in
order to update user-defined information. They will directly adjust certain parameters in the back end.
