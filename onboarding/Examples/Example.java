// Copyright (c) 2025 FRC 6423 - Ward Melville Iron Patriots
// https://github.com/FIRSTTeam6423
// 
// Open Source Software; you can modify and/or share it under the terms of
// MIT license file in the root directory of this project

// Above is our license header
// This is automatically added to all files in the repository with the spotlessApply command

package onboarding.Examples;

// Class names should always be UpperCamelCase
// Classes should always have a doc comment
public class Example {
    // * CONSTANTS
    // Constants are always SCREAMING_SNAKE_CASE
    // They also always use the 'public static final' keywords
    public static final double IM_A_CONSTANT = 64.23;

    // Enums are UpperCamelCase and are singular (e.g. 'ShooterState' not 'ShooterStates')
    public static enum ShooterState {
        IDLE,
        SPINNING_UP,
        AT_SPEED,
        SHOOTING
    }

    // Records are UpperCamelCase
    // Doc comments are required for records
    public record LoggableState(
        boolean motorIsOk,
        double motorSetpointRevsPerSec,
        double motorSpeedRevsPerSec,
        double motorAppliedVolts,
        double motorCurrentAmps
    ) {}

    // * FIELDS
    // Fields are always lowerCamelCase
    // They also always use the 'private' keyword
    private ShooterState state = ShooterState.IDLE;

    //  If a field is a constant, use the 'final' keyword
    private final SparkMax flywheelMotor = new SparkMax(1, MotorType.kBrushless);

    // * CONSTRUCTORS
    // Constructors are always UpperCamelCase
    public Example() {
        // ...
    }

    // * METHODS
    // Methods typically are verbs or verb phrases for example 'setElevatorSpeed' or 'stop'
    // Methods are always lowerCamelCase
    
    // Doc comments are required for all public methods
    // Here's an example of a setter
    /**
     * Sets speed of elevator motors
     * 
     * @param speed in revolutions per second
     * @param focEnabled true if field oriented control is enabled
     */
    public void setElevatorSpeed(double speed, boolean focEnabled) {
        // ...
    }

    // Here's an example of a getter
    /**
     * @return {@link ShooterState} representing the current state of the shooter
     */
    public ShooterState getState() {
        return state;
    }
}