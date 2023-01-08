// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drive.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DisabledState extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem drive;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DisabledState(DriveSubsystem drive) {
    this.drive = drive;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      drive.frontLeft.setAngle(0);
      drive.frontRight.setAngle(0);
      drive.rearLeft.setAngle(0);
      drive.rearRight.setAngle(0);

      drive.frontLeft.setSpeed(0);
      drive.frontRight.setSpeed(0);
      drive.rearLeft.setSpeed(0);
      drive.rearRight.setSpeed(0);

      drive.frontLeft.setBrakeMode(true);
      drive.frontRight.setBrakeMode(true);
      drive.rearLeft.setBrakeMode(true);
      drive.rearRight.setBrakeMode(true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
