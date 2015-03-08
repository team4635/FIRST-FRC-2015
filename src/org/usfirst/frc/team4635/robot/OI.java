package org.usfirst.frc.team4635.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4635.robot.commands.Multiplier;
import org.usfirst.frc.team4635.robot.commands.elevator.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//Joysticks
	//Estas son las opciones de Joystick que podemos utilizar durante la competencia:
	//
    //Joystick leftAttack3Joystick = new Joystick(RobotMap.leftAttack3JoystickPort);
    //Joystick rightAttack3Joystick = new Joystick(RobotMap.rightAttack3JoystickPort);
    //Joystick xboxJoystick = new Joystick(RobotMap.xboxJoystickPort);
    //Joystick launchpadJoystick = new Joystick(RobotMap.launchpadJoystickPort);
	Joystick attack3Joystick = new Joystick(RobotMap.attack3JoystickPort);
	Joystick launchpadJoystick = new Joystick(RobotMap.launchpadJoystickPort);
    //Buttons
    //Este es el mappeo de botones de los controladores:
    //
    Button btnElevatorUp = new JoystickButton(attack3Joystick, RobotMap.elevatorUpPort);
    Button btnElevatorDown = new JoystickButton(attack3Joystick, RobotMap.elevatorDownPort);
    Button btnElevatorStop = new JoystickButton(attack3Joystick, RobotMap.elevatorStopPort);
    
    Button btnElevatorUpOverride = new JoystickButton(attack3Joystick, RobotMap.elevatorUpOverridePort);
    Button btnElevatorDownOverride = new JoystickButton(attack3Joystick, RobotMap.elevatorDownOverridePort);
    
    Button btnElevatorUpArcade = new JoystickButton(launchpadJoystick, RobotMap.launchpadUp);
    Button btnElevatorDownArcade = new JoystickButton(launchpadJoystick, RobotMap.launchpadDown);
    
    Button btnPanRightArcade = new JoystickButton(launchpadJoystick, RobotMap.launchpadMat1x1);
    Button btnPanLeftArcade = new JoystickButton(launchpadJoystick, RobotMap.launchpadMat1x2);
    
    Button btnVerticalRight = new JoystickButton(attack3Joystick, RobotMap.verticalRightPort);
    Button btnVerticalLeft = new JoystickButton(attack3Joystick, RobotMap.verticalLeftPort);
    
    Button btnMulti50 = new JoystickButton(launchpadJoystick, RobotMap.launchpadMat3x1);
    Button btnMulti75 = new JoystickButton(launchpadJoystick, RobotMap.launchpadMat3x2);
    Button btnMulti100 = new JoystickButton(launchpadJoystick, RobotMap.launchpadMat3x3);
    Button btnMultiInverted = new JoystickButton(launchpadJoystick, RobotMap.launchpadMat2x3);
    
 
    
    //Button btn3 = new JoystickButton(attack3Joystick, RobotMap.elevatorDownPort);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    //btn.set();
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    //button1.whenReleased(new ExampleCommand());
	
	//Metodos
	//Aqui van los metodos para conseguir valores de los Joysticks
	
	//NO UTILIZADOS
	//
	//    public double getleftAttack3Joystick() {
	//        return leftAttack3Joystick.getRawAxis(1); //look up what the actual axis number is
	//    }
	//    public double getrightAttack3Joystick() {
	//        return leftAttack3Joystick.getRawAxis(1); //look up what the actual axis number is
	//    }
    public OI() {
    	//btnElevatorUp.whenPressed(new ElevatorUp()); //Eje Y
        //btnElevatorDown.whenPressed(new ElevatorDown()); //Eje Y
        //btnElevatorStop.whenPressed(new ElevatorStop()); //Eje Y
        btnElevatorUpOverride.whileHeld(new ElevatorDownOverride()); //Eje Y
        btnElevatorDownOverride.whileHeld(new ElevatorUpOverride()); //Eje Y
        btnElevatorUpArcade.whenPressed(new ElevatorUp()); //Eje Y
        btnElevatorDownArcade.whenPressed(new ElevatorDown()); //Eje Y
        btnMulti50.whenPressed(new Multiplier(0.5));
        btnMulti75.whenPressed(new Multiplier(0.75));
        btnMulti100.whenPressed(new Multiplier(1));
        btnMultiInverted.whenPressed(new Multiplier(-1));
        //btnPanLeftArcade.whileHeld(new Pan(-1));
        //btnShake.whenPressed(new Shake());
        
        
        //btnVerticalRight.whenPressed(new Rotate(30)); //Eje Y
        //btn3.whenPressed(new ElevatorStop()); //Eje Y
    } 
	
	public double getJoystickY() {
        return attack3Joystick.getRawAxis(RobotMap.yStick); //Eje Y
    }
	public double getJoystickX() {
        return attack3Joystick.getRawAxis(RobotMap.xStick); //Eje X
    }
	public double getJoystickXCStick() {
        return attack3Joystick.getRawAxis(RobotMap.xCStick); //Eje X
    }
	public double getThrottle() {
        return attack3Joystick.getRawAxis(2); //Eje del throttle
    }
}

