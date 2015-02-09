
package org.usfirst.frc.team4635.robot.subsystems;

import org.usfirst.frc.team4635.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
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
	DigitalInput topSwitch = new DigitalInput(RobotMap.topSwitchPort);
	//Counter bottomCounter = new Counter(bottomSwitch);

	private double state = -1; // This defines the level in which the elevator is located
	private double nState = 5; //Number of states
	private boolean inState = false; //This is place to true if override takes over.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void up() {
    	ventana.set(Relay.Value.kOn);
    	ventana.set(Relay.Value.kForward);
    }
    public void down() {
    	ventana.set(Relay.Value.kOn);
    	ventana.set(Relay.Value.kReverse);
    }
    public void stop() {
    	ventana.set(Relay.Value.kOff);
    }
    
    
  //Regresa si detecta una linea negra 
    public boolean isSwitchSet() {
    	boolean blackLine = ai2.getVoltage() > 4;
    	
    	return blackLine;
    }
    //Regresa si detecta una linea negra y le pudes camibar el estado
    public boolean isSwitchSet(int value) {
    	boolean blackLine = ai2.getVoltage() > 4;
    	
    	if (blackLine){
    		updateState(value);
    		return true;
    	} else
    		return false;
    }
    //Switch de limite para saber si esta hasta arriba
    public boolean isTopSet() {
    	if(topSwitch.get()){
    		state=nState;
    		return true;
    	} else
    		return false;
    }
    //Switch de limite para saber si esta hasta abajo
    public boolean isBottomSet() {
    	if(bottomSwitch.get()){
    		state=0;
    		return true;
    	} else
    		return false;
    }
    //Regresa el voltaje (calibrado)
    public double getVoltage(){
    	return ai2.getVoltage();
    }
    //Regresa el nivel en el que se encuentra el elevador
    public double getState(){
    	return state;
    }
    //Puedes marcar el estado manualmente
    public void setState(double value){
    	state=value;
    }
    //Modifica el estado agregando o restando dependiendo si esta subiendo o bajando
    public void updateState(double value){
    	if(value==1 || value==-1 || value==-0.5 || value==0.5){
	    	if(value%1==0.5){
	    		if (inState)
	    			System.out.println("Error: How is this possible?");
	    		else{
		    		inState=true;
		    		state=state+value;
	    		}
	    	}else if (inState){
	    		value=value/2;
	    		state=state+value;
	    	}else
	    		state=state+value;
    	} else
    		System.out.println("Error: How is this possible?");
    }
}

