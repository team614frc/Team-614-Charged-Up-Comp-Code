package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveTrainSubsystem;

public class Robot extends TimedRobot {

  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    DriveTrainSubsystem.zeroHeading();
    RobotContainer.elevatorSubsystem.resetElevatorEncoders();
    RobotContainer.tiltSubsystem.resetTiltEncoders();
    RobotContainer.driveTrainSubsystem.resetEncoderValues();
    RobotContainer.driveTrainSubsystem.followerLeftMotor.burnFlash();
    RobotContainer.driveTrainSubsystem.followerRightMotor.burnFlash();
    RobotContainer.driveTrainSubsystem.leaderLeftMotor.burnFlash();
    RobotContainer.driveTrainSubsystem.leaderRightMotor.burnFlash();
    RobotContainer.manipulator.intakeMotor.burnFlash();
    RobotContainer.elevatorSubsystem.elevatorLeftMotor.burnFlash();
    RobotContainer.elevatorSubsystem.elevatorRightMotor.burnFlash();
    RobotContainer.tiltSubsystem.tiltRightMotor.burnFlash();
    RobotContainer.tiltSubsystem.tiltLeftMotor.burnFlash();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("Tilt Right Encoder Value", RobotContainer.tiltSubsystem.getRightHeight());
    SmartDashboard.putNumber("Tilt Left Encoder Value", RobotContainer.tiltSubsystem.getLeftHeight());
    // RobotContainer.ledSubsystem.setLedColorOrange();
  }

  @Override
  public void disabledInit() {
    // RobotContainer.ledSubsystem.setLedColorOrange();
    RobotContainer.driveTrainSubsystem.setBreakMode();
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void disabledExit() {
  }

  @Override
  public void autonomousInit() {
    DriveTrainSubsystem.zeroHeading();

    RobotContainer.driveTrainSubsystem.navX.reset();

    RobotContainer.tiltSubsystem.resetTiltEncoders();
    RobotContainer.driveTrainSubsystem.resetEncoderValues();
    RobotContainer.elevatorSubsystem.resetElevatorEncoders();

    RobotContainer.driveTrainSubsystem.setBreakMode();

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null)
      m_autonomousCommand.schedule();
  }

  public void autonomousPeriodic() {
  }

  public void autonomousExit() {
    RobotContainer.driveTrainSubsystem.setCoastMode();
  }

  @Override
  public void teleopInit() {
    // Cancles any scheduled auto commands in teleop mode
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void teleopExit() {
  }

  @Override
  public void testInit() {
    // Cancles all scheduled auto commands in test mode
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
    SmartDashboard.putNumber("Current ticks of elevator", RobotContainer.elevatorSubsystem.getHeight());
  }

  @Override
  public void testExit() {
  }
}
