
package org.usfirst.frc.team4635.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.subsystems.DriveTrain;

/**
 *
 */
public class Rotate extends Command {

	private double anguloDes= 0.00f;
	private double anguloAct= 0.00f;
	private double vMax= 0.5f;
	private double vMin= 0.3f;
	private double velocidad= 0.00f;
	private boolean positivo = true;
	private int loopCounter =0;
    public Rotate(double value) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveTrain);
        requires(Robot.variables);
        anguloDes=value;
        if(anguloDes>0)
        	positivo = true;
        else
        	positivo = false;
        Robot.variables.setManualDrive(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.analogDevices.resetGyro();
    	loopCounter=0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while (anguloAct<anguloDes){
	    	anguloAct=Robot.analogDevices.getGyro();
	    	velocidad=((vMin-vMax)/Math.pow(anguloDes,2))*Math.pow((anguloAct-(anguloDes/2)), 2)+vMax;
	    		((DriveTrain) Robot.DriveTrain).perfectDrive(0,-0.5);
	    		
	    	System.out.println(anguloAct+" : "+anguloDes+" : "+velocidad+" : "+loopCounter);
	    	loopCounter++;
	    	if (loopCounter>=200)
	    		break;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	    return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("end true");
    	((DriveTrain) Robot.DriveTrain).drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("interrupted");
    	((DriveTrain) Robot.DriveTrain).drive(0,0);
    }
}
