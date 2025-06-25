# Codebase Structure
This doc will teach you how we structure our codebases. If you wish to follow along, you can checkout the [akit version of our 2025 codebase](https://github.com/wmironpatriots/CompetitionRobot2025/tree/junk/akitRewrite)

### Common Terminology
* *Directory (Dir for short)* - A folder
* *Repository (Repo for short)* - An online storage location for our project's code

### Paths
Lets look at a simple folder structure
```
📦documents
 ┣ 📂pictures
 ┃ ┗ 📜familyPhotos.png
 ┗ 📂videos
 ┃ ┗ 📜babysFirstSteps.mp4
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
 ┣ 📜settings.gradle (Build Files)
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
 ┣ 📂java
```
***The Deploy Directory:*** files in this directory will be sent to the RoboRIO (the robot's computer) into the 'deploy directory.' This is usally where we store autonomous paths (files with the `*.traj` extension) and vision configurations.

***The Java Directory:*** this is where all Java code is.

Since the Java dir is where the actual code is, you'll be modifying files in there usally.

### Java Directory
Here's what you'll find in the `java` dir
```
📦CompetitionRobot2025/src/main/java
 ┣ 📂lib
 ┣ 📂wmironpatriots
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
 ┣ 📜Robot.java
```

## The Actual Code
Congrats, you've found the actual code. Lets talk about what each of these classes do. Then lets explore the subpackages in the main package.

### `Main.java`
The main class serves as an entry point

```
package wmironpatriots;

import edu.wpi.first.wpilibj.RobotBase;

public final class Main {
  private Main() {}

  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
```