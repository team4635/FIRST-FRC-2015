
package org.usfirst.frc.team4635.robot.commands.drivetrain;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.subsystems.DriveTrain;

/**
 *
 */
public class Drive extends Command {

	public double speed=0.00;
	private double timeFinal = 0;
	private double seconds=0;
    public Drive(double vReq, double tReq) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveTrain);
        speed=vReq;
        seconds=tReq;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timeFinal=Timer.getFPGATimestamp()+seconds;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		((DriveTrain) Robot.DriveTrain).drive(speed,speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timeFinal<=Timer.getFPGATimestamp()){
        	return true;
        }else{
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	((DriveTrain) Robot.DriveTrain).drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	((DriveTrain) Robot.DriveTrain).drive(0,0);
    }
}
