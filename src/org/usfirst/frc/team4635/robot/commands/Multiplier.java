package org.usfirst.frc.team4635.robot.commands;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Multiplier extends Command {

	private double multiplier = 1;
    public Multiplier(double mReq) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	System.out.println("testbefore");
    	multiplier = mReq;
    	requires(Robot.DriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	((DriveTrain) Robot.DriveTrain).setMultiplier(multiplier);
    	System.out.println("Multiplier: "+((DriveTrain) Robot.DriveTrain).getMultiplier());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
