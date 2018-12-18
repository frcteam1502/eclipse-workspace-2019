package org.usfirst.frc.team1502.robot.subsystems;

import org.usfirst.frc.team1502.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	 DoubleSolenoid armSolenoid = null;
	
	public Arm() {
		armSolenoid = new DoubleSolenoid(RobotMap.ARM_SOLENOID_OPEN, RobotMap.ARM_SOLENOID_CLOSE);
	}
	
	public void pitchUp() {
		armSolenoid.set(Value.kForward);
	}
	
	public void pitchDown() {
		armSolenoid.set(Value.kReverse);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

