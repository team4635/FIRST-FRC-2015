package org.usfirst.frc.team4635.robot.commands;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.subsystems.camera;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pan extends Command {

	private double angle = 0.00;
    public Pan(double value) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cam);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cam.setPan(Robot.cam.getPan()+angle);
    	
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
