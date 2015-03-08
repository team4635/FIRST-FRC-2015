package org.usfirst.frc.team4635.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4635.robot.commands.drivetrain.Drive;
import org.usfirst.frc.team4635.robot.commands.elevator.ElevatorUp;

/**
 *
 */
public class AutonomousForwardBox extends CommandGroup {
    
    public  AutonomousForwardBox() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//Normal
    	addSequential(new Drive(0.5, 1));
    	addParallel(new Drive(0.5, 5));
    	addSequential(new ElevatorUp());
    	
    	//addSequential(new ElevatorUp());
    	//addSequential(new Rotate(0.5, 1));
    }
}
