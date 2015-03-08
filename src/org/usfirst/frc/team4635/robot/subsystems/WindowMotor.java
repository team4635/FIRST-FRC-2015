
package org.usfirst.frc.team4635.robot.subsystems;

import org.usfirst.frc.team4635.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WindowMotor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Relay ventana = new Relay(RobotMap.elevatorMotorPort);
	AnalogInput ai2 = new AnalogInput(RobotMap.analogElevator);
	
	DigitalInput bottomSwitch = new DigitalInput(RobotMap.bottomSwitchoPort);
	//DigitalInput topSwitch = new DigitalInput(RobotMap.topSwitchPort);
	Counter bottomCounter = new Counter(bottomSwitch);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void up() {
    	ventana.set(Relay.Value.kOn);
    	ventana.set(Relay.Value.kReverse);
    }
    public void down() {
    	ventana.set(Relay.Value.kOn);
    	ventana.set(Relay.Value.kForward);
    }
    public void stop() {
    	ventana.set(Relay.Value.kOff);
    }
    
    
  //Regresa si detecta una linea negra 
    public boolean isSwitchSet() {
    	boolean blackLine = ai2.getVoltage() > 4;
    	
    	return blackLine;
    }
    //Switch de limite para saber si esta hasta abajo
    public boolean isBottomSet() {
    	if(bottomSwitch.get()){
    		return true;
    	} else
    		return false;
    }
    public void initializeCounter() {
    	bottomCounter.reset();
    }
    //Regresa el voltaje (calibrado)
    public double getVoltage(){
    	return ai2.getVoltage();
    }
}

