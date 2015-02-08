
package org.usfirst.frc.team4635.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.subsystems.DriveTrain;

/**
 *
 */
public class verticalRight extends Command {

    public verticalRight() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	((DriveTrain) Robot.DriveTrain).drive(0,0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.analogDevices.resetGyro();
    	System.out.println(Robot.analogDevices.getGyro());
    	while(Robot.analogDevices.getGyro()>-10){
    		((DriveTrain) Robot.DriveTrain).drive(0.5,0, 1);
    	}
    	System.out.println(Robot.analogDevices.getGyro());
    	((DriveTrain) Robot.DriveTrain).drive(0,0.5, 1);
    	Timer.delay(0.5);
    	while(Robot.analogDevices.getGyro()<=0){
    		((DriveTrain) Robot.DriveTrain).drive(-0.5,0, 1);
    	}
    	((DriveTrain) Robot.DriveTrain).drive(0,0);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	((DriveTrain) Robot.DriveTrain).drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
