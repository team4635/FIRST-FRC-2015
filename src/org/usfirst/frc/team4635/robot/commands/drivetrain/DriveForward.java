package org.usfirst.frc.team4635.robot.commands.drivetrain;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	int loopCounter =0;
	double voltage =0.00;
	double deseo = 1.5;
    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveTrain);
    	requires(Robot.analogDevices);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	loopCounter =0;
    	voltage = 0.00;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	((DriveTrain) Robot.DriveTrain).drive(0.5,0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	voltage = Robot.analogDevices.getVoltage();
    	if (voltage>deseo){
    		if(loopCounter>5){
    			return true;
    		} else {
    			return false;
    		}
    	}
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
