
package org.usfirst.frc.team4635.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4635.robot.Robot;

/**
 *
 */
public class ElevatorUpOverride extends Command {

	private boolean isInLimits=true;
	
    public ElevatorUpOverride() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.WindowMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	checkLimits();
    	Robot.WindowMotor.updateState(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.WindowMotor.up();
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (isInLimits)
    		return true;
    	else
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.WindowMotor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.WindowMotor.stop();
    }
    private void checkLimits() {
    	isInLimits=Robot.WindowMotor.isTopSet();
    }
}
