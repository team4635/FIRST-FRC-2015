
package org.usfirst.frc.team4635.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4635.robot.Robot;

/**
 *
 */
public class ElevatorDown extends Command {

	private int counter=0;
	private boolean isInLimits=true;
    public ElevatorDown() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.WindowMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	counter=0;
    	checkLimits();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!isInLimits)
    		Robot.WindowMotor.down();
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	checkLimits();
    	if (counter>20)
    		return (Robot.WindowMotor.isSwitchSet(-1) || isInLimits);
    	else if (isInLimits)
    		return true;
    	else
    		counter++;
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
    	isInLimits=Robot.WindowMotor.isBottomSet();
    }
}
