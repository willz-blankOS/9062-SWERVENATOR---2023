// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.swing.plaf.FontUIResource;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // ----------------
    // MOTOR ID'S
    // ----------------

    public static final int FRONT_LEFT_FORWARD_ID = 1;
    public static final int FRONT_LEFT_ROTATION_ID = 2;
    
    public static final int FRONT_RIGHT_FORWARD_ID = 4;
    public static final int FRONT_RIGHT_ROTATION_ID = 5;

    public static final int REAR_LEFT_FORWARD_ID = 7;
    public static final int REAR_LEFT_ROTATION_ID = 8;

    public static final int REAR_RIGHT_FORWARD_ID = 10;
    public static final int REAR_RIGHT_ROTATION_ID = 11;

    // ----------------------
    // CANCODER ID'S
    // ----------------------

    public static final int FRONT_LEFT_CONCODER_ID = 3;
    public static final int FRONT_RIGHT_CONCODER_ID = 6;
    public static final int REAR_LEFT_CONCODER_ID = 9;
    public static final int REAR_RIGHT_CONCODER_ID = 12;

    // ----------------------------------
    //  JOYSTICKS - OPERATOR AND DRIVER
    // ----------------------------------

    public static final int DRIVER_JOYSTICK_ID = 0;
    public static final int OPERATOR_JOYSTICK_ID = 1;

    public static final double DRIVER_X_THRESHOLD = 0.1;
    public static final double DRIVER_Y_THRESHOLD = 0.1;

    public static final double OPERATOR_X_THEESHOLD = 0.1;
    public static final double OPERATOR_Y_THRESHOLD = 0.1;

    // ----------------
    // PID VALUES
    // ----------------

    public static final double FRONT_LEFT_FORWARD_PID0_P = 0.002;
    public static final double FRONT_LEFT_FORWARD_PID0_I = 0;
    public static final double FRONT_LEFT_FORWARD_PID0_D = 0;
    public static final double FRONT_LEFT_FORWARD_PID0_FF = 0.2;

    public static final double FRONT_LEFT_ROTATION_PID0_P = 0.00201;
    public static final double FRONT_LEFT_ROTATION_PID0_I = 0.00095;
    public static final double FRONT_LEFT_ROTATION_PID0_D = 0;
    public static final double FRONT_LEFT_ROTATION_PID0_FF = 0.0001;

    public static final double FRONT_RIGHT_FORWARD_PID0_P = 0.002;
    public static final double FRONT_RIGHT_FORWARD_PID0_I = 0;
    public static final double FRONT_RIGHT_FORWARD_PID0_D = 0;
    public static final double FRONT_RIGHT_FORWARD_PID0_FF = 0.2;

    public static final double FRONT_RIGHT_ROTATION_PID0_P = 0.00201;
    public static final double FRONT_RIGHT_ROTATION_PID0_I = 0.00095;
    public static final double FRONT_RIGHT_ROTATION_PID0_D = 0;
    public static final double FRONT_RIGHT_ROTATION_PID0_FF = 0.0001;

    public static final double REAR_LEFT_FORWARD_PID0_P = 0.002;
    public static final double REAR_LEFT_FORWARD_PID0_I = 0;
    public static final double REAR_LEFT_FORWARD_PID0_D = 0;
    public static final double REAR_LEFT_FORWARD_PID0_FF = 0.2;

    public static final double REAR_LEFT_ROTATION_PID0_P = 0.00201;
    public static final double REAR_LEFT_ROTATION_PID0_I = 0.00095;
    public static final double REAR_LEFT_ROTATION_PID0_D = 0;
    public static final double REAR_LEFT_ROTATION_PID0_FF = 0.0001;

    public static final double REAR_RIGHT_FORWARD_PID0_P = 0.002;
    public static final double REAR_RIGHT_FORWARD_PID0_I = 0;
    public static final double REAR_RIGHT_FORWARD_PID0_D = 0;
    public static final double REAR_RIGHT_FORWARD_PID0_FF = 0.2;

    public static final double REAR_RIGHT_ROTATION_PID0_P = 0.00201;
    public static final double REAR_RIGHT_ROTATION_PID0_I = 0.00095;
    public static final double REAR_RIGHT_ROTATION_PID0_D = 0;
    public static final double REAR_RIGHT_ROTATION_PID0_FF = 0.0001;

    // -------------------
    // GEAR RATIOS
    // -------------------

    public static final double DRIVE_GEAR_RATIO = 6.75;
    public static final double ROTATION_GEAR_RATIO = 21.4285714;
    
    // ----------------------------------------------
    // ROBOT DIMENSTION - FOR SWERVE CALCULATIONS
    // ----------------------------------------------

    public static final double SIDE_LENGTH = 19.0;
    public static final double SIDE_TO_CORNER = 26.8700576851;

    // -------------------
    // LIMITS
    // -------------------
}
