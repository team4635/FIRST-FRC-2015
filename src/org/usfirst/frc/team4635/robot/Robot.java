
package org.usfirst.frc.team4635.robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4635.robot.subsystems.*;
import org.usfirst.frc.team4635.robot.commands.Autonomous;
import org.usfirst.frc.team4635.robot.commands.Teleop;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final Subsystem DriveTrain =new DriveTrain();
	public static final WindowMotor WindowMotor =new WindowMotor();
	public static final analogDevices analogDevices =new analogDevices();
	public static final Variables variables =new Variables();
	public static final camera cam = new camera();
	//public static final SerialCommunications Arduino =new SerialCommunications();
	public static OI oi;

    Command Teleop;
    Command Autonomous;
    Command Test;
    
    
   
	BuiltInAccelerometer acc = new BuiltInAccelerometer();
    //SerialPort arduino;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        Teleop = new Teleop();
        Autonomous = new Autonomous();
        //arduino.writeString("Eugenio 4635");
      
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (Autonomous != null) Autonomous.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (Autonomous != null) Autonomous.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Teleop.start();
        //arduino.writeString("on");
        //System.out.println("X: "+acc.getX()+"Y: "+acc.getY()+"Z: "+acc.getZ()+"Gyro: ");
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
