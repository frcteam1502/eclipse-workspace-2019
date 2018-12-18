package org.usfirst.frc.team1502.robot.subsystems;

import org.usfirst.frc.team1502.robot.RobotMap;
import org.usfirst.frc.team1502.robot.commands.ArcadeCommands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	//Motor Controllers
	TalonSRX leftFrontTalon = null;
	TalonSRX leftBackTalon = null;
	TalonSRX rightFrontTalon = null;
	TalonSRX rightBackTalon = null;
	
	ArcadeDrive arcadeDrive = null;
	TankDrive tankDrive = null;
	Arm arm = null;
	
	
	public Drivetrain() {
		//Talons
		leftFrontTalon = new TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftBackTalon = new TalonSRX(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightBackTalon = new TalonSRX(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON); 
		
		//Drive Systems
		arcadeDrive = new ArcadeDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon);
		tankDrive = new TankDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon);
		
		//Components		
		arm = new Arm();
		
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		arcadeDrive.move(moveSpeed, rotateSpeed);
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed) {
		tankDrive.move(leftSpeed, rightSpeed);
	}

	public static double expRate(double x, double exp) {
		if (x >= 0) {
			return Math.pow(x, exp);
		} else {
			return -Math.pow(-x, exp);
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeCommands());
    }
}

