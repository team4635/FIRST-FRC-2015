package org.usfirst.frc.team4635.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.command.Command;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command test2;
	RobotDrive myRobot;
	Joystick stick;
	Relay mVentana;
	Button btn_a;
	Button btn_b;

	
	int autoLoopCounter;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
   	    myRobot = new RobotDrive(0,1,2,3);
    	stick = new Joystick(0);
    	mVentana = new Relay(0);
    	btn_a = new JoystickButton(stick, 1);
    	btn_b = new JoystickButton(stick, 2);

    }
    	
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void aupruebatonomousInit() {
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
 	   
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
   	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	myRobot.arcadeDrive(stick); 
    	if(btn_a.get() || btn_b.get()){
    		mVentana.set(Relay.Value.kOn);
    		if(btn_a.get()){
    			mVentana.set(Relay.Value.kForward);
    		}else if(btn_b.get()){
    			mVentana.set(Relay.Value.kReverse);
    		}
    	}
    	else{
    	   mVentana.set(Relay.Value.kOff);
       }
  	  
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
       
       
    }
  
}
