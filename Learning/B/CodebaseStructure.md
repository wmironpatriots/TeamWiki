# Codebase Structure
This doc will teach you how we structure our codebases. If you wish to follow along, you can checkout our [2025 codebase's (development branch)](https://github.com/wmironpatriots/CompetitionRobot2025/tree/development)

### Common Terminology
* *Directory (Dir for short)* - A folder
* *Repository (Repo for short)* - An online storage location for our project's code

### Paths
Lets look at a simple folder structure
```
📦documents
 ┣ 📂pictures
 ┃ ┗ 📜familyPhotos.png
 ┣ 📂videos
 ┗ ┗ 📜babysFirstSteps.mp4
```
The path to the `familyPhotos.png` is `documents/pictures/familyPhotos.png`

## Pt. 1 (Finding the Code)
### Root Directory
Here's what you'll find when you first open the repo
```
📦CompetitionRobot2025
 ┣ 📂.devcontainer (Repository Organization)
 ┣ 📂.vscode (Repository Organization)
 ┣ 📂.wpilib (Build Files)
 ┣ 📂assets (Repository Organization)
 ┣ 📂gradle (Build Files)
 ┣ 📂src [[THE ACTUAL CODE]]
 ┣ 📂vendordeps (Build Files)
 ┣ 📜.gitignore (Repository Organization)
 ┣ 📜AUTHORS.md (Repository Organization)
 ┣ 📜LICENSE (Repository Organization)
 ┣ 📜README.md (Repository Organization)
 ┣ 📜WPIlib-License.md (Repository Organization)
 ┣ 📜build.gradle (Build Files)
 ┣ 📜gradlew (Build Files)
 ┣ 📜gradlew.bat (Build Files)
 ┗ 📜settings.gradle (Build Files)
```

All of these directories/files can be sorted into 2 categories:

***Repository Organization:*** these are files ease management of this project (via versioning, workflows, etc) 

***Build Files:*** these are files that assist with the build process. Instead of compiling everything with java manually, we use gradle to setup automations for building.

The actual code lies in the `src` directory. The name of this directory is short for the word **"source."**

### Source Directory
Here's what you'll find in the `src` dir
```
📦CompetitionRobot2025/src/main
 ┣ 📂deploy
 ┗ 📂java
```
***The Deploy Directory:*** files in this directory will be sent to the RoboRIO (the robot's computer) into the 'deploy directory.' This is usally where we store autonomous paths (files with the `*.traj` extension) and vision configurations.

***The Java Directory:*** this is where all Java code is.

Since the Java dir is where the actual code is, you'll be modifying files in there usally.

### Java Directory
Here's what you'll find in the `java` dir
```
📦CompetitionRobot2025/src/main/java
 ┣ 📂lib
 ┗ 📂wmironpatriots
```

Folders in the `java` dir are called packages. Packages are essentially folders containing many related java classes. The short version of packages is ***pkg***

***The Team Library, aka the `lib` dir:*** code that will be used in future codebases (ex: non-game specific utils, drivers, etc).

***`wmironpatriots` (the main package):*** the actual robot code.

The team library shouldn't be tampered.

### The `wmironpatriots` pkg
This is the actual meat of the codebase.
```
📦CompetitionRobot2025/src/main/java/wmironpatriots
 ┣ 📂subsystems
 ┣ 📂utils
 ┣ 📜Constants.java
 ┣ 📜Main.java
 ┗ 📜Robot.java
```

## The Actual Code
Congrats, you've found the actual code. Lets talk about what each of these classes do. Then lets explore the subpackages in the main package.

### `Main.java`
The main class contains our entry point. Here, we create a new Robot object.

```Java
package wmironpatriots;

import edu.wpi.first.wpilibj.RobotBase;

public final class Main {
  private Main() {}

  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
```

### `Robot.java`
This class represents the entire robot. It's responsible for all initalization.

```Java
package wmironpatriots;

import static edu.wpi.first.units.Units.Seconds;

import com.ctre.phoenix6.SignalLogger;
...

public class Robot extends CommandRobot implements Logged {
  // HARDWARE
  private final CommandXboxController driver = new CommandXboxController(0);
  private final CommandXboxController operator = new CommandXboxController(1);

  private final Swerve swerve = Swerve.create();
  private final Superstructure superstructure = Superstructure.create();

  // ALERTS
  private final Alert browningOut;

  public Robot() {
    ...

    configureBindings();
    configureGameBehavior();
  }

  private void configureBindings() {
    ...
  }

  private void configureGameBehavior() {
    ...
  }

  @Override
  protected Command getAutonCommand() {
    ...
  }
}
```
###### ***(The ... means that we're skipping over code that we aren't focusing on)***

***Fields:*** We create all of our hardware fields (input devices, subsystems, etc) and initalize them outside of the constructor. This is to keep the constructor clean.

***Constructor:*** This is where we configure most of the systems (logging, driverstation, etc). Notice that we also call the `configureBindings` method and the `configureGameBehavior` method.

***`configureBindings`:*** This is where all driver and operator inputs are defined. 

***`configureGameBehavior`:*** This is where we configure the robot's behavior during certain sections of a match (Autonomous, Teleoperated, Disabled, etc)

***`getAutonCommand`:*** We'll talk more about Commmands later, so ignore this for now

Notice how the `Robot` class extends the `CommandRobot` class and implements the `Logged` class. 

### `Constants.java`
Constants are final static values. All constants should be screaming snake case.

### The `subsystems` pkg
```
📦CompetitionRobot2025/src/main/java/wmironpatriots/subsystems
 ┣ 📂swerve
 ┣ 📂superstructure
 ┃ ┣ 📂arm
 ┃ ┃ ┣ 📜Arm.java
 ┃ ┃ ┣ 📜ArmHardware.java
 ┃ ┃ ┣ 📜ArmHardwareReal.java
 ┃ ┃ ┗ 📜ArmHardwareSim.java
 ┃ ┣ 📂elevator
 ┃ ┃ ┗ ...
 ┃ ┣ 📂arm
 ┃ ┃ ┗ ...
 ┗ ┗ 📜superstructure.java
```

The `subsystems` pkg contains all classes related to subsystems. We'll talk about how subsystem classes should be structured later.