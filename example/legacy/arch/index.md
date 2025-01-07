## Our codebase
### Command Based programming
Command based programming is a form of declerative programming. It revolves around two concepts:
Subsystems and Commands. A subsystem is a group of hardware that forms a system on our robot. For example,
the intake, shooter, and climber on our 2024 robot are subsystems. These are sort of the 'nouns' of our robots.
If the robot is a body, the subsystems are the parts of it. Commands are the 'verbs' of our robot. Actions the robot
can take. Commands can use multiple parts of the 'body' to do these actions. We can take multiple of these command actions and compose them together. For example, we could have a command that passed the note in the intake to the shooter and a command that spins up the shooter. We could put these together to make a pass-&-shoot command.

We use command based programming keep our code clean and effective, but to use command based programming effectivily you need to understand good command based practices.

The next exercise will involve commands

# Next: [Exercise 1](../Tutorials/Tutorial-01/Index.md)