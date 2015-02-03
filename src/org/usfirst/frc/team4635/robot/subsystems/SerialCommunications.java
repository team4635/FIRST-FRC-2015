
package org.usfirst.frc.team4635.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SerialCommunications extends Subsystem {
    
	SerialPort arduino = new SerialPort(9600, Port.kUSB);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void writeMsg(String text){
    	arduino.writeString(text);
    }
    public void reset(){
    	arduino.reset();
    }
}

