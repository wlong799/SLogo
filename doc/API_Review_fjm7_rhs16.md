Part 1
======

1. The most flexible part of the API is supposed to be that the model is to be completely separate from everything else. It needs only an observer to be listening for when the model pushes out a new TurtleState. This means that the model should be able to be used, in theory, by any other front end that is able to feed the model with text instructions, then be able to read the TurtleState object.

2. The API encapsulates the implementation due to the controller which is supposed to have very limited contact with the model.

3. I would have to worry about errors when incorrect commands are given. In case of incorrect spelling or syntax, I will need to throw an error and pass that up to the external part of the back end. Then, the error will be displayed in the 'console' of the GUI.

4. I think parts of this API are good because it is careful with the Turtle is holds on to. Rather than giving the Turtle itself to the controller, it will give only parts of the Turtle that are necessary to make a view in the skeleton that is TurtleState.

Part 2
======

1. 
* user types in 'fs' instead of 'fd' for 'forward':
this is an incorrect spelling, syntax error. Therefore this will be caught when parsing the commands, and will be sent to the external part of the back end in order to signal to the front end that there was a syntax error.

* user wants to execute a function that will take the dataStorage beyond the current view:
the model will execute the function as normal--the dataStorage only has position variables. The front end will decide what the best way to handle this is: it can either expand the view to fit the dataStorage, do nothing at all, or it can signal to the back end that there should be an error. In the error case, the dataStorage can revert to its previous position before the last set of commands was put into the model.

* user issues a command to move the dataStorage forward 50:
the model will parse the command, then execute it. The execution will see that the dataStorage needs to move forward by 50 in the direction it is already facing. Through trigonometric identities and geometry, it will calculate the changes in the x and y coordinates in the Turtle and update them. Because the Turtle is updated, the model will create a new TurtleState object to be seen by the controller.

* user issues a command to set a different pen color:
the model directly modifies the Turtle object to have the different pen color attribute. A new TurtleState object may be made, but in this case the view will not need to do anything with it.

* a user wants to reference a variable that does not exist:
there will be nothing to call in the model with that variable name. This may not be recognized during parsing, since the variables may be defined in the same code block. Therefore, this will be recognized during code execution. An error will be passed to display to the user (for which the controller will be listening), and the dataStorage will revert to the state it was in before it began executing the code tree.

2. Regular expressions will help with parsing instructions. This will enable us to make the code tree easily. The observer and observable will help let the controller know if the Turtle is updated or if an error is thrown and needs to be displayed to the user.

3. I am most excited to work on command parsing. It is going to be a challenge how to create and use the tree structure made from parsing. I think that with support from the members in my team, we can figure out how to correctly have the commands execute on each other.

4. I am most worried to be working on passing up the TurtleState from the Model to the view (by the view listening in on when the model gives a TurtleState). This is because this was the biggest point of contention when we were making the design document. It took us almost three hours to discuss how the view would be updated and given the new specifications for how it should be updated. I fear that with different ideas of how it should be done, each person may write code to how they assume the view is updated, not to what actually happens.
