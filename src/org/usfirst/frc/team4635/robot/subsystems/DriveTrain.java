
package org.usfirst.frc.team4635.robot.subsystems;

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
	AnalogInput ai = new AnalogInput(0);
    public void initDefaultCommand() {
    	myRobot.drive(0, 0);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double speedLeft, double speedRight) {
    	myRobot.tankDrive(speedLeft, speedRight);
    }
    public void drive(double xSpeed, double ySpeed, double yThrottle) {
    	if(ai.getVoltage()<=1.72f)
    		myRobot.arcadeDrive(ySpeed*yThrottle*sensorIR(ai.getVoltage()), xSpeed*yThrottle+(1/3));
    	
    	else
    		myRobot.arcadeDrive(oneKind(false, ySpeed*yThrottle+(1/3)), xSpeed*yThrottle+(1/3));
    }
    public void stop(){
    	myRobot.drive(0, 0);
    }
  //Negative =0, Positive=1
    private double oneKind(boolean negative, double value){
    	if (negative==false && value<0)
    		value=0;
    	else if(negative==true && value>0)
    		value=0;
    	return value;
    }
    private double sensorIR(double voltaje){
    	double value=0.00f;
    	double startline=1;
    	double stopline=1.72;
    	if (voltaje<1)
    		return 1;
    	value=voltaje/stopline;
    	return 1-value;
    }
}

