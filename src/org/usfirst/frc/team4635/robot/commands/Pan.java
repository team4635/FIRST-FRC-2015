package org.usfirst.frc.team4635.robot.commands;

import org.usfirst.frc.team4635.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pan extends Command {

	public Pan(double value) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cam);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.cam.getPan()<0){
    		Robot.cam.setPan(180.0f);
    		System.out.println("PAN");
    	}
    	else{
    		Robot.cam.setPan(-180.0f);
    		System.out.println("PAN");
    	}
    	
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
