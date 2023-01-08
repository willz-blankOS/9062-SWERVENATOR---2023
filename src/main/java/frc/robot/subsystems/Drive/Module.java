package frc.robot.subsystems.Drive;

import java.util.function.DoubleBinaryOperator;

import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;

public class Module {
    private CANSparkMax forward;
    private CANSparkMax rotate;
    private CANCoder rotationCANCoder;
    private SparkMaxPIDController forwardPID, rotatePID; 
    private int DRIVE_ID, ROTATION_ID, CANCODER_ID;

    public Module(int DRIVE_ID, int ROTATION_ID, int CANCODER_ID){
        this.DRIVE_ID = DRIVE_ID;
        this.ROTATION_ID = ROTATION_ID;
        this.CANCODER_ID = CANCODER_ID;
        setup();
    }

    public void setup(){
        forward = new CANSparkMax(DRIVE_ID, MotorType.kBrushless);
        rotate = new CANSparkMax(ROTATION_ID, MotorType.kBrushless);
        rotationCANCoder = new CANCoder(CANCODER_ID);

        forwardPID = forward.getPIDController();
        rotatePID = rotate.getPIDController();
        rotate.getEncoder().setPositionConversionFactor(((1 / Constants.ROTATION_GEAR_RATIO) * 360) % 360);
        forward.getEncoder().setPositionConversionFactor((1 / Constants.DRIVE_GEAR_RATIO) * Math.PI * 4);

        forwardPID.setFeedbackDevice(forward.getEncoder());
        rotatePID.setFeedbackDevice(rotate.getEncoder());

        forward.getEncoder().setPosition(0.0);
        rotate.getEncoder().setPosition(0.0);
    }

    public void setNormal(){
        forward.setIdleMode(IdleMode.kCoast);
        rotate.setIdleMode(IdleMode.kBrake);
    }

    public void setBrakeMode(Boolean mode){
        if(mode){
            forward.setIdleMode(IdleMode.kBrake);
            rotate.setIdleMode(IdleMode.kBrake);
        }else{
            forward.setIdleMode(IdleMode.kCoast);
            rotate.setIdleMode(IdleMode.kCoast);        
        }
    }

    public void setForwardPID(double p, double i, double d, double ff, int slotID){
        forwardPID.setP(p, slotID);
        forwardPID.setI(i, slotID);
        forwardPID.setD(d, slotID);
        forwardPID.setFF(ff, slotID);

    }

    public void setRotationPID(double p, double i, double d, double ff, int slotID){
        rotatePID.setP(p, slotID);
        rotatePID.setI(i, slotID);
        rotatePID.setD(d, slotID);
        rotatePID.setFF(ff, slotID);
        //rotatePID.setIZone(2.0);
        rotatePID.setOutputRange(-180, 180);
    }

    public void setSpeed(double speed){
        forward.set(speed);
    }

    public void setSpeedVoltage(double speed){
        forward.setVoltage(speed);
    }

    public void setSpeedPID(double speed){
        forwardPID.setReference(speed, ControlType.kDutyCycle);
    }

    public void setAngle(double target){
        if(target > 180){
            target -= 360;
        }
        
        rotatePID.setReference(target, ControlType.kPosition);
    }

    public double getAngle(){
        return rotate.getEncoder().getPosition();
    }

    public double getDistance(){
        return forward.getEncoder().getPosition();
    }
}