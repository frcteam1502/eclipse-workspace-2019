package org.usfirst.frc.team1502.robot.commands;

import org.usfirst.frc.team1502.robot.Robot;
import org.usfirst.frc.team1502.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankCommands extends Command {

    public TankCommands() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Set Drive Values - Cubic Control
    	double leftStick = Drivetrain.expRate(Robot.m_oi.leftJoystick.getY(), 3);
    	double rightStick = -Drivetrain.expRate(Robot.m_oi.leftJoystick.getY(), 3);
    	
    	Robot.drivetrain.tankDrive(leftStick, rightStick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
