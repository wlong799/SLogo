Michael Schroeder
Rachel Bransom

#### Peer API Review

### Part 1

1. What about your API/design is intended to be flexible?

	* I am working on the back-end, and more specifically, the parsing of commands. Our design is intended to be flexible in terms of the type of command that is entered into the command line. There is going to be one abstract superclass for all commands, that will only contain the method execute, which allows the back-end and the controller to work with different commands, as well as execute them, without caring what type of command it is (whether or not it affects the dataStorage, how many parameters it takes, etc.). Additionally, the back-end doesn't care about how the front end is implemented. The Turtle will likely just have a State object, that will contain all of the information that any type of view could use to visualize the dataStorage. This will likely be a set of coordinates, an orientation, an image, whether or not the pen is up and down, etc. This way, any front-end can just ask for this data from the dataStorage, and make its own decisions about how to display it.

2. How is your API/design encapsulating your implementation decisions?

	* The actual parsing of the commands is encapuslated from the rest of the back-end. The Command class (and any class that uses Commands) doesn't have to have any dependence on the implementation of the parsing, as the CommandParser will create the Commands itself. This means that in order to change the way that commands are parse, changes only need to be made to the ExpressionTree class (if using an ExpressionTree), and the CommandParser. Other implementation decisions that are encapsulated are how the actual model updates. The front end doesn't care about how the dataStorage calculates it's next position, it only gets the dataStorage's state after the change has been made.

3. What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?

	* Most of the error cases that my part will handle are invaid commands. This includes commands in an incorrect language (which may or may not be able to trigger a specific "wrong language" error), incomplete commands (leaving off a parameter, also might have a specific error), and otherwise non-commands (typing "fasdafwera" is just not a command). These will be handled either by a) throwing an Exception, and displaying an error message, b) if possible, predicting what the user might have meant (if we are able to implement fuzzy string matching, we could guess that "forwad 50" means "forward 50", or suggesting that "forward" needs another parameter).

4. Why do you think your API/design is good (also define what your measure of good is)?

	* I think that my API/design is good, specifically with respect to the Command hierarchy, because it allows Commands to be handled very abstractly by any part of the code that needs to use them. There won't have to be a lot of switch statements on Commands, as they will all be able to run the "execute()" function, which means that they can always be used generically by the class that executes the commands (CommandExecuter). Additionally, the CommandParsing will also hopefully be well-separated from the rest of the back-end.

### Part 2

1. 5 use cases
	1. A user wants to run a single command "fd 50"
	2. A user wants to run a specified function (multiple commands in a row)
	3. A user wants to run a command from the command history (by clicking on it)
	4. A user inputs an invalid command
	5. A user wants to change the language the commands are parsed in 

2. How do you think at least one of the "advanced" Java features will help you implement your design?
	
	* I think that reflection will be helpful in creating the Command classes from the parsed strings. Reflection will make it so there doesn't have to be any conditonal checks based on the string in order to instantiate the specific command class. Additionally, the Observer/Observable pattern will be used with the connection between the Turtle and the display of the dataStorage (whenever a command is executed, the Turtle's state will change, and this will notify the back-end).

3. What feature/design problem are you most excited to work on?

	* I'm most excited to work on the parsing of commands and working with regular expressions. I've had some experience in the past working with regular expressions, so it will be interesting to see how to use them in this case.

4. What feature/design problem are you most worried about?
	
	* I'm most worried about dealing with the communication between the front and back ends, making sure that the communication is clear and well-defined, and that we don't create many dependencies between the two. 

