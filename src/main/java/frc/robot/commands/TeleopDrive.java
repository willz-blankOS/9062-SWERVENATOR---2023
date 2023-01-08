// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drive.DriveSubsystem;

import javax.swing.JList.DropLocation;

import org.opencv.core.Mat;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem drive;

  private double x1, y ,x2;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public TeleopDrive(DriveSubsystem drive, double x1, double y, double x2) {
    this.drive = drive;
    this.x1 = x1;
    this.y = y;
    this.x2 = x2;

    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // ------------------------
    // SWERVE CALCULATIONS
    // ------------------------

    x1 = drive.driverController.getRawAxis(0);
    x2 = drive.driverController.getRawAxis(2);
    y = drive.driverController.getRawAxis(1);

    //double magnitude = Math.sqrt(Math.pow(x1, 2) + Math.pow(y, 2));

    double a = x1 - x2 * (Constants.SIDE_LENGTH / (Constants.SIDE_TO_CORNER / 2));
    double b = x1 + x2 * (Constants.SIDE_LENGTH / (Constants.SIDE_TO_CORNER / 2));
    double c = y - x2 * (Constants.SIDE_LENGTH / (Constants.SIDE_TO_CORNER / 2));
    double d = y + x2 * (Constants.SIDE_LENGTH / (Constants.SIDE_TO_CORNER / 2));

    double frontleftspeed = Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2));
    double frontrightspeed = Math.sqrt(Math.pow(b, 2) + Math.pow(d, 2));
    double rearleftspeed = Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2));
    double rearrightspeed = Math.sqrt(Math.pow(a, 2) + Math.pow(d, 2));

    double frontleftangle = Math.atan2(b, c) * (180 / Math.PI);
    double frontrightangle = Math.atan2(b, d) * (180 / Math.PI);
    double rearleftangle = Math.atan2(a, c) * (180 / Math.PI);
    double rearrightangle = Math.atan2(a, d) * (180 / Math.PI);

    // -----------------------

    // ------------------------------------------
    //  SET WHEEL ANGLE AND SPEED USING INPUT
    // ------------------------------------------

    //if(Math.signum(x1) * x1 > Constants.DRIVER_X_THRESHOLD || Math.signum(x2) * x2 > Constants.DRIVER_X_THRESHOLD && Math.signum(x2) < Constants.DRIVER_Y_THRESHOLD){
        drive.frontLeft.setSpeedPID(frontleftspeed);
        drive.frontRight.setSpeedPID(frontrightspeed);
        drive.rearLeft.setSpeedPID(rearleftspeed);
        drive.rearRight.setSpeedPID(rearrightspeed);

        drive.frontLeft.setAngle(frontleftangle);
        drive.frontRight.setAngle(frontrightangle);
        drive.rearLeft.setAngle(rearleftangle);
        drive.rearRight.setAngle(rearrightangle);
   /* }else if(Math.signum(x1) * x1 < Constants.DRIVER_X_THRESHOLD || Math.signum(x2) * x2 < Constants.DRIVER_X_THRESHOLD && Math.signum(x2) > Constants.DRIVER_Y_THRESHOLD){
      drive.frontLeft.setAngle(45);
      drive.frontRight.setAngle(135);
      drive.rearLeft.setAngle(-45);
      drive.rearRight.setAngle(-135);

      if(x2 > 0){
        drive.frontLeft.setSpeedPID(frontleftspeed);
        drive.frontRight.setSpeedPID(frontrightspeed);
        drive.rearLeft.setSpeedPID(rearleftspeed);
        drive.rearRight.setSpeedPID(rearrightspeed);

      }else if(x2 < 0){
        drive.frontLeft.setSpeedPID(-frontleftspeed);
        drive.frontRight.setSpeedPID(-frontrightspeed);
        drive.rearLeft.setSpeedPID(-rearleftspeed);
        drive.rearRight.setSpeedPID(-rearrightspeed);
      }
    }else if(Math.signum(x1) * x1 > Constants.DRIVER_X_THRESHOLD || Math.signum(x2) * x2 > Constants.DRIVER_X_THRESHOLD && Math.signum(x2) > Constants.DRIVER_Y_THRESHOLD){
      drive.frontLeft.setSpeedPID(frontleftspeed);
      drive.frontRight.setSpeedPID(frontrightspeed);
      drive.rearLeft.setSpeedPID(rearleftspeed);
      drive.rearRight.setSpeedPID(rearrightspeed);

      frontleftangle += 45;
      frontrightangle += 45;
      rearleftangle += 45;
      rearrightangle += 45;

      if(frontleftangle > 180){ // FRONT LEFT
        frontleftangle -= 360;
      }
      drive.frontLeft.setAngle(frontleftangle);

      if(frontrightangle > 180){ // FRONT RIGHT
        frontrightangle -= 360;
      }
      drive.frontRight.setAngle(frontrightangle);
      
      if(rearleftangle > 180){ // REAR LEFT
        rearleftangle -= 360;
      }
      drive.rearLeft.setAngle(rearleftangle);

      if(rearrightangle > 180){ // REAR RIGHT
        rearrightangle -= 360;
      }
      drive.rearRight.setAngle(rearrightangle);
    }else{
      drive.frontLeft.setSpeed(0);
      drive.frontRight.setSpeed(0);
      drive.rearLeft.setSpeed(0);
      drive.rearRight.setSpeed(0);
    }
    */

    SmartDashboard.putNumber("FRONT LEFT TARGET", frontleftangle);
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
