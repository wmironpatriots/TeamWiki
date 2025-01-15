## Control Systems Intro

Controls system are a wildly complicated topic. They're so complicated, that they have their own engineering field, control engineering. Since we program robots, we do have to deal with control systems; However, you don't need a crazy understanding of the entire field. You only need a couple of bits and pieces.

A "Control system" is basically multiple electrionic devices that regulate other devices or system using control loops. These are real things, they're moe like computerized concepts. Think about it this way: a motor that controls a robot arm is unable to move by itself. First off there needs to be actual input; a control that moves it maybe. Then there needs to be something that actually controls the voltage to a motor, like a motor controller. But the system also needs to be able to tell the position of the arm, most likely through an absolute encoder. All of these components are part of a single system that controls the arm. This is just a single example of a control system.

Control systems exist all around us. Your computer's cooling system is a control system. Your air conditioning unit is a control system. Your heater? A control system.

### Control methods
Lets go back to the robot arm example for a second: how do I get the arm to move at precise positions? 

Well assuming I know what motor is driving the arm, I could just calculate how long I would have to run voltage to the motor to get it at the position. 

### Control methods
