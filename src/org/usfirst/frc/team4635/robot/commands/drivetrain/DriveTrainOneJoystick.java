
package org.usfirst.frc.team4635.robot.commands.drivetrain;


import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.subsystems.DriveTrain;

/**
 *
 */
public class DriveTrainOneJoystick extends Command {

    public DriveTrainOneJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		//((DriveTrain) Robot.DriveTrain).drive(-Robot.oi.getJoystickX(),Robot.oi.getJoystickY(), -Robot.oi.getThrottle());
    	//((DriveTrain) Robot.DriveTrain).drive(-Robot.oi.getJoystickX(), -Robot.oi.getJoystickX());
    	((DriveTrain) Robot.DriveTrain).perfectDrive(Robot.oi.getJoystickY()*Robot.oi.getThrottle(),Robot.oi.getJoystickX()*Robot.oi.getThrottle()+-1*Robot.oi.getJoystickXCStick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
