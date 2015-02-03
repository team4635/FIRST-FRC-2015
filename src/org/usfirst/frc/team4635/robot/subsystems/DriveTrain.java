
package org.usfirst.frc.team4635.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive myRobot = new RobotDrive(0,1,2,3);
    public void initDefaultCommand() {
    	myRobot.drive(0, 0);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double speedLeft, double speedRight) {
    	myRobot.tankDrive(speedLeft, speedRight);
    }
    public void drive(double xSpeed, double ySpeed, double yThrottle) {
    	myRobot.arcadeDrive(ySpeed*yThrottle, xSpeed);
    }
    public void stop(){
    	myRobot.drive(0, 0);
    }
}

