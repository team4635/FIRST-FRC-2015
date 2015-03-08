package org.usfirst.frc.team4635.robot.commands;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shake extends Command {

    public Shake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Test");
    	double tempTime = Timer.getFPGATimestamp()+10;
    	while(tempTime >=Timer.getFPGATimestamp()){
    		((DriveTrain) Robot.DriveTrain).perfectDrive(0, 0.5);
    	}
    	((DriveTrain) Robot.DriveTrain).perfectDrive(0, 0.5);
    	Timer.delay(1);
    	((DriveTrain) Robot.DriveTrain).perfectDrive(0, 0);
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
