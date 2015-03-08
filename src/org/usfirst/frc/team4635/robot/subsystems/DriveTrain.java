
package org.usfirst.frc.team4635.robot.subsystems;

import org.usfirst.frc.team4635.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive myRobot = new RobotDrive(RobotMap.robotDriveLeftFront, RobotMap.robotDriveLeftRear, RobotMap.robotDriveRightFront, RobotMap.robotDriveRightRear);
	
	double multiplier = 1;
	
    public void initDefaultCommand() {
    	myRobot.drive(0, 0);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setMultiplier(double value){
    	multiplier = value;
    }
    public double getMultiplier(){
    	return multiplier;
    }
    public void drive(double speedLeft, double speedRight) {
    	myRobot.tankDrive(speedLeft*multiplier, speedRight*1.05*multiplier);
    }
    public void drive(double xSpeed, double ySpeed, double yThrottle) {
    	//myRobot.arcadeDrive(sensorIRX(ai.getVoltage(), ySpeed)*yThrottle, sensorIRY(ai.getVoltage(), xSpeed)*yThrottle, true);
    	myRobot.arcadeDrive(ySpeed*yThrottle*multiplier, xSpeed*yThrottle*multiplier);
    	//System.out.println(ai.getVoltage());
    }
    public void stop(){
    	myRobot.drive(0, 0);
    }
    public void perfectDrive(double moveValue, double rotateValue){
        double leftMotorSpeed;
        double rightMotorSpeed;
    	if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }
    	myRobot.tankDrive(leftMotorSpeed*multiplier, rightMotorSpeed*multiplier);
    	//System.out.println("left: "+leftMotorSpeed+"--- right: "+rightMotorSpeed);
    }
    public void rotate(){
    	
    }
}

