API Review
==========
Will Long (wpl5)
Grant Costa (gac19)
October 13, 2016

We both are working on the front-end, focusing especially on the
internal View API.

Part 1
======
1. My code is designed to be flexible in terms of what components can be
on the screen, and what they do. This is achieved by creating each
separate part of the GUI within its own class. A single GUI class is 
responsible for posititoning the elements on the screen, and then they
are responsible for their implementation. This will make it much easier
to add new components to the screen in the future, or to extend the
capabilities of already-created GUI elements. I hope to also implement 
the components in a way so that they are resizable, so that if the 
overall application window is resized by the window, the main GUI layout
class will be able to properly adjust the sizes of the different
components.  
2. As stated earlier, because I place each individual GUI element into
its own class, the implementation of each component is encapsulated
from the others. The elements don't need to worry about their layout, as
that is also controlled by another class. Furthermore, a controller
class will be responsible for handling interactions between the GUI
elements (e.g. setting up the various EventListeners and Bindings). 
Furthermore, communication to the back-end will strictly be through the
controller class, ensuring less of the View is exposed to the Model.
3. The main exception to deal with will be when invalid code is sent to
the Model for parsing. The Model will throw an exception in this case.
When this happens, the Controller class will be responsible for
handling the error, and sending the appropriate signals to the various
parts of the GUI so they update properly (e.g. tell the CommandHistory
element to display the recently entered text in red, with the error
message). Another possible error may be if the Turtle starts to move
outside the screen. In this case, the TurtleView class will be
responsible for rescaling the coordinate space of the main view, so it
remains on screen.  
4. I think my API design is good because it encapsulates the
implementation of each component, which will promote flexibility in the
future. Adding new features to the GUI will be made much simpler because
of this. Everything is laid out in a way that should make intuitive
sense as well, which is important for maintaining code readability.
Because communication to the back-end occurs through a single class, it
is also easy to see what is sent to the back-end, and how. Finally, the
use of bindings between the various GUI components and parts of the 
back-end ensure that whenever something in the back-end is updated, the
View will be updated properly.

Part 2
======
1. **USE CASES**
  * User clicks on a function in the FunctionStorage box, and it is 
  placed in the TextEntry box for execution.  
  * User changes the language to be used for parsing through the 
  toolbar at the top of the app.  
  * User changes which helper bar is displayed on the right side of the
  screen (e.g. CommandHistory vs. FunctionStorage).  
  * User inputs a command and submits it.  
  * User opens up the help screen HTML file.  
2. Binding will allow for the GUI elements to be updated automatically,
as soon as their relevant parts in the Model have been changed.
3. I'm excited to figure out how to properly draw the turtle on the
screen based on information from the back-end, and to set up my GUI
in a user-friendly and appealing manner.
4. I'm worried about figuring out how to properly set up communication
between the back-end and front-end through bindings, and setting up
the different elements of the GUI to "talk" to each other correctly.
