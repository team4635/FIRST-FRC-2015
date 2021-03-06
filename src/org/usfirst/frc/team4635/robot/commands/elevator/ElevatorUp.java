
package org.usfirst.frc.team4635.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4635.robot.Robot;

/**
 *
 */
public class ElevatorUp extends Command {

	private int contador=0;
    public ElevatorUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.WindowMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	contador=0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.WindowMotor.up();
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(contador<100){
    		contador++;
    	}
    	else
    		return Robot.WindowMotor.isSwitchSet();
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
}
