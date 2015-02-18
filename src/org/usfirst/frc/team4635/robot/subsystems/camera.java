package org.usfirst.frc.team4635.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Servo pan = new Servo(9);
	Servo tilt = new Servo(8);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double getTilt(){
    	return tilt.getAngle();
    }
    public double getPan(){
    	return pan.getAngle();
    }
    public void setTilt(double value) {
    	//value=maxAngle(value);
    	tilt.setAngle(value);
    }
    public void setPan(double value) {
    	//value=maxAngle(value);
    	pan.setAngle(value);
    }
    public double maxAngle(double value){
    	if (value > 180.0) {
            return 180.0;
        }
        if (value < -180.0) {
            return -180.0;
        }
    	return value;
    }
    
}

