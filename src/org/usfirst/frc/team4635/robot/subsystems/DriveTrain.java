
package org.usfirst.frc.team4635.robot.subsystems;

import org.usfirst.frc.team4635.robot.Robot;
import org.usfirst.frc.team4635.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive myRobot = new RobotDrive(0,1,2,3);
	AnalogInput ai = new AnalogInput(RobotMap.analogForward);
	
	double correctWay = 0;
	double Kp =0.03;
	
    public void initDefaultCommand() {
    	double test = Robot.analogDevices.getGyro();
    	myRobot.drive(0, 0);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double speedLeft, double speedRight) {
    	myRobot.tankDrive(speedLeft, speedRight);
    }
    public void drive(double xSpeed, double ySpeed, double yThrottle) {
    	myRobot.arcadeDrive(sensorIRX(ai.getVoltage(), ySpeed)*yThrottle, sensorIRY(ai.getVoltage(), xSpeed)*yThrottle, true);
    	//myRobot.arcadeDrive(ySpeed*yThrottle, xSpeed*yThrottle );
    	//System.out.println(ai.getVoltage());
    }
    public void stop(){
    	myRobot.drive(0, 0);
    }
    private double sensorIRX(double voltaje, double speed){
    	double startline=0.7;
    	double stopline=1.70;
    	if (voltaje<startline)
    		return speed;
    	else {
	    	//Checks if going forwards, else it gives normal speed going backwards
	    	if (speed>0)
	    		return speed;
	    	else{
		    	double value=0.00f;
		    	double tantitoMas=stopline+0.3;
		    	
		    	value=voltaje/(stopline);
		    	if (value>0.9){
		    		value=0.9;
		    	}
		    	return speed*(1-value);
	    	}
    	}
    }
    private double sensorIRY(double voltaje, double speed){
    	double startline=0.7;
    	double stopline=1.70;
    	if (voltaje<startline)
    		return speed;
    	else {
	    	double value=0.00f;
	    	double tantitoMas=stopline+0.3;
	    	
	    	value=(voltaje/stopline)*0.5;
	    	return speed*(1-value);
    	}
    }
    private void checkWay(){
    	double angle = Robot.analogDevices.getGyro();
    	correctWay=angle*Kp;
    	
    }
}

