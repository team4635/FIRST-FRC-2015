package org.usfirst.frc.team4635.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//
	// Map of Joysticks
    // 
	public static int attack3JoystickPort = 0;
    public static int leftAttack3JoystickPort = 1;
    public static int rightAttack3JoystickPort = 2;
    public static int xboxJoystickPort = 3;
    public static int launchpadJoystickPort = 4;
    
    //
	// Map of Buttons
    // 
    public static int elevatorUpPort = 1;
    public static int elevatorDownPort = 2;
    public static int elevatorStopPort = 3;
    public static int elevatorUpOverridePort = 11;
    public static int elevatorDownOverridePort = 10;
    
    public static int verticalRightPort = 5;
    public static int verticalLeftPort = 4;
    
    //
    // Map of ElevatorMotors
    //
    public static int elevatorMotorPort = 0;
    
    //
    // Map of Analog Inputs
    //
    public static int analogForward = 1;
    public static int gyroPort = 0;
    public static int analogElevator =2;
    
    //
    // Map of Digital Inputs
    //
    public static int topSwitchPort = 1;
    public static int bottomSwitchoPort = 0;
}
