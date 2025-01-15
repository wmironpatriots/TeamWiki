## Field Oriented Control with brushless motors

Field Oriented Control (FOC) AKA vector control is a type of motor controlling that allows you to control the velocity, acceleration, and torque of a motor. This allows motors to have smooth movement over their full speedrange and torque at zero speed. FOC control is important in robotics, as it allows for more fluid and dynamic movement overall. The torque control can also be used to dampen the motor like a spring.

While we can't use FOC with the sparkmax motor controllers (No foc with NEOs womp womp), the talonFX motor controller that's built into the krakens allow for FOC control. This is why we use krakens mainly for swerve.

### Init a talonFX device

```Java
// All of our CTRe devices (Krakens, Pigeons, CANcoders, etc)
// are located on a seperate CAN loop called the CANivore loop
// the two arguements should be 
// the ID (1) and the CANbus ID ("CTReBus")
final TalonFX m_leftLeader = new TalonFX(1, "CTReBus");
```