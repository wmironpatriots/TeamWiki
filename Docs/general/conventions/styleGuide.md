## Style Guide and codebase general format 

Currently, our team uses the [Google java Style guide](https://google.github.io/styleguide/javaguide.html)

### Package/class naming
Our team's codebases usually use the following structure:
- wmironpatriot
  - Main.java
  - Robot.java
  - Constants.java
  - util
    - deviceUtils
      - ControllerUtil.java
  - subsystems
    - arm
      - Arm.java
      - ArmIOComp.java
      - ArmIOSim.java
    - swerve
      - ...

#### Class names
* Hardware interface classes should always be named in the following format: ```SubsystemIOHardware.java```
    * For example, if you had a ```Turret.java``` subsystem class that needed a simulated hardware class + a competition robot hardware class you would name them ```TurretIOSim.java``` & ```TurretIOComp.java```
* Util files should be sorted into specific utility folders
  * Util class names should end with 'Util'