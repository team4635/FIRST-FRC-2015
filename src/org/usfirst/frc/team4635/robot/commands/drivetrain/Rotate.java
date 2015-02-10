
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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	anguloAct=Robot.analogDevices.getGyro();
    	velocidad=((vMin-vMax)/Math.pow(anguloDes,2))*Math.pow((anguloAct-(anguloDes/2)), 2)+vMax;
    	((DriveTrain) Robot.DriveTrain).drive(0.5,0);
    	System.out.println(anguloAct+" : "+anguloDes+" : "+velocidad);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	    if (positivo && anguloAct>anguloDes){//Si el angulo desado es positivo compara que el actual sea mayor
	    	System.out.println("true");
	    	Robot.variables.setManualDrive(true);
	    	return true;
	    }
	    else if (!positivo && anguloAct<anguloDes){//Si el angulo desado es negativo compara que el angulo actual sea menor
	    	System.out.println("true");
	    	Robot.variables.setManualDrive(true);
	    	return true;
	    }
	    System.out.println("false else");
	    return false;
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
