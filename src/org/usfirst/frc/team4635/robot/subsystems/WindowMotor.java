
package org.usfirst.frc.team4635.robot.subsystems;

import org.usfirst.frc.team4635.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WindowMotor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Relay ventana = new Relay(RobotMap.elevatorMotorPort);
	//DigitalInput limitSwitch = new DigitalInput(0);
	//Counter counter = new Counter(limitSwitch);

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
    
//    public boolean isSwitchSet() {
//        return counter.get() > 0;
//    }
//    public void initializeCounter() {
//        counter.reset();
//    }

}

