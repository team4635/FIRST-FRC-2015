package org.usfirst.frc.team4635.robot.subsystems;

import org.usfirst.frc.team4635.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class analogDevices extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Gyro gyro = new Gyro(RobotMap.gyroPort);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double getGyro(){
    	return gyro.getAngle();
    }
    public void resetGyro(){
    	gyro.reset();
    }
}

