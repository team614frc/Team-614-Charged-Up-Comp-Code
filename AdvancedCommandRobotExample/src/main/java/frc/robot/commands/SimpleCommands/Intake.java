package frc.robot.commands.SimpleCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Intake extends CommandBase {
  public double intakeSpeed;
  public Timer timer;
  boolean stopCommand;
  public Intake(double intakespeed) {
    addRequirements(RobotContainer.manipulator);
    intakeSpeed = intakespeed;
    timer = new Timer();
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.manipulator.set(intakeSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.manipulator.set(Constants.MANIPULATOR_SPEED_REST);
  
  }

  // gets returned true when the command ends
  @Override
  public boolean isFinished() {
    // double currentTime = timer.get();
    // if ((RobotContainer.manipulator.pdh.getCurrent(Constants.INTAKE_MOTOR) >= Constants.MANIPULATOR_THRESHOLD)
    //     && currentTime > 1) {
    //       SmartDashboard.putBoolean("Picked Up game piece:", true);
    //       stopCommand = true;
    // } else {
    //   stopCommand = false;
    //   SmartDashboard.putBoolean("Picked Up game piece:", false);
    // }
    // SmartDashboard.putNumber("Current Outputted by PDH:",
    // RobotContainer.manipulator.pdh.getCurrent(Constants.INTAKE_MOTOR));
    return RobotContainer.isArmUp;
  }
}
