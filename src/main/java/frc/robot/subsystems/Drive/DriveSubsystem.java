// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Module frontLeft = new Module(Constants.FRONT_LEFT_FORWARD_ID, Constants.FRONT_LEFT_ROTATION_ID, Constants.FRONT_LEFT_CONCODER_ID);
  public Module frontRight = new Module(Constants.FRONT_RIGHT_FORWARD_ID, Constants.FRONT_RIGHT_ROTATION_ID, Constants.FRONT_RIGHT_CONCODER_ID);
  public Module rearLeft = new Module(Constants.REAR_LEFT_FORWARD_ID, Constants.REAR_LEFT_ROTATION_ID, Constants.REAR_LEFT_CONCODER_ID);
  public Module rearRight = new Module(Constants.REAR_RIGHT_FORWARD_ID, Constants.REAR_RIGHT_ROTATION_ID, Constants.REAR_RIGHT_CONCODER_ID);

  public Joystick driverController = new Joystick(Constants.DRIVER_JOYSTICK_ID);

  public DriveSubsystem() {
      setup();
  }

  public void setup(){
    // ------------------
    // SET PID VALUES
    // ------------------

    frontLeft.setForwardPID(
        Constants.FRONT_LEFT_FORWARD_PID0_P, 
        Constants.FRONT_LEFT_FORWARD_PID0_I, 
        Constants.FRONT_LEFT_FORWARD_PID0_D, 
        Constants.FRONT_LEFT_FORWARD_PID0_FF, 0);

    frontLeft.setRotationPID(
        Constants.FRONT_LEFT_ROTATION_PID0_P, 
        Constants.FRONT_LEFT_ROTATION_PID0_I, 
        Constants.FRONT_LEFT_ROTATION_PID0_D, 
        Constants.FRONT_LEFT_ROTATION_PID0_FF, 0);

    frontRight.setForwardPID(
        Constants.FRONT_RIGHT_FORWARD_PID0_P, 
        Constants.FRONT_RIGHT_FORWARD_PID0_I, 
        Constants.FRONT_RIGHT_FORWARD_PID0_D, 
        Constants.FRONT_RIGHT_FORWARD_PID0_FF, 0);

    frontRight.setRotationPID(
        Constants.FRONT_RIGHT_FORWARD_PID0_P, 
        Constants.FRONT_RIGHT_ROTATION_PID0_I, 
        Constants.FRONT_RIGHT_ROTATION_PID0_D, 
        Constants.FRONT_RIGHT_ROTATION_PID0_FF, 0);

    rearLeft.setForwardPID(
        Constants.REAR_LEFT_FORWARD_PID0_P, 
        Constants.REAR_LEFT_FORWARD_PID0_I, 
        Constants.REAR_LEFT_FORWARD_PID0_D, 
        Constants.REAR_LEFT_FORWARD_PID0_FF, 0);

    rearLeft.setRotationPID(
        Constants.REAR_LEFT_ROTATION_PID0_P, 
        Constants.REAR_LEFT_ROTATION_PID0_I, 
        Constants.REAR_LEFT_ROTATION_PID0_D, 
        Constants.REAR_LEFT_ROTATION_PID0_FF, 0);

    rearRight.setForwardPID(
        Constants.REAR_RIGHT_FORWARD_PID0_P, 
        Constants.REAR_RIGHT_FORWARD_PID0_I, 
        Constants.REAR_RIGHT_FORWARD_PID0_D, 
        Constants.REAR_RIGHT_FORWARD_PID0_FF, 0);

    rearRight.setRotationPID(
        Constants.REAR_RIGHT_ROTATION_PID0_P, 
        Constants.REAR_RIGHT_ROTATION_PID0_I, 
        Constants.REAR_RIGHT_ROTATION_PID0_D, 
        Constants.REAR_RIGHT_ROTATION_PID0_FF, 0);
  }

  public void displayWheelInfo(){
      SmartDashboard.putNumber("FL ANGLE", frontLeft.getAngle());
      SmartDashboard.putNumber("FR ANGLE", frontRight.getAngle());
      SmartDashboard.putNumber("RL ANGLE", rearLeft.getAngle());
      SmartDashboard.putNumber("RR ANGLE", rearRight.getAngle());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    displayWheelInfo();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
