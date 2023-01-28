package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Manipulator;

    //Manipulator code by Danial and Zabir

public class Intake extends CommandBase{
public double intakeSpeed;
    public Intake(double x){
        addRequirements(RobotContainer.manipulator);
        intakeSpeed = x;
    }
  
    @Override
  public void initialize() {
    
  }

  public void test(){

  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //If left bumper is pressed, turns the motor on in order to take the game piece in, and grip it
    RobotContainer.manipulator.set(intakeSpeed);
  }
  @Override
  public void end(boolean interrupted) {
    RobotContainer.manipulator.set(Constants.STOP_MOTOR);
  }
  //gets returned true when the command ends
  @Override
  public boolean isFinished() {
    return false;
  }
}
