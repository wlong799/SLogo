SLogo API
=========

Pre-Design API Plan
-------------------

### Internal Back End
Parse the given input into understandable commands. Throw some error / put defaults in case of bad parsing. Understand the given commands: is
it given a single command, a group of commands, a function? Put all these commands into a backlog of commands to execute. Execute commands
in the order they were given by finding the position of the dataStorage (as of yet undecided where will live... Perhaps as in intermediary
between the front end and back end), and then giving those calculations to the External part of the back end. Becuase this part will know of
the Turtle's location, it will also be able to throw any errors based on the Turtle going beyond its specified bounds or attempting to execute
any other illegal operation. These instructions will be given to the External part of the back end so that it can be given to the front end
and displayed to the user.

### External Back End
Accepting communications from the user-defined SLogo commands. The CommandManager will be the only class
accepting input from the SLogoManager, which is the channel of communication between the external back end and the
external front end APIs. The SLogoManager takes the output from the front end (the commands that have been input)
and forwards them along to the back end (via the CommandManager) to be parsed. This allows for a very simple
external back end API, encapsulating most of the functionality from the front end.

### Internal Front End
The Internal Front End API describes the elements of the GUI, including the command line, the Turtle display window,
and a list of previously executed commands/allowable pre-determined/customizable functions.

### External Front End
The external api takes in a queue of commands that have been created by the back end and executes the commands in the queue. It also sends
the user text input to the back end to be parsed. 
