package com.team2502.titanium.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.team2502.titanium.OI;
import com.team2502.titanium.RobotMap;
import com.team2502.titanium.command.DriveCommand;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrainSubsystem extends Subsystem
{
    private static final Pair<Double, Double> SPEED_CONTAINER = new Pair<Double, Double>();

    public final WPI_TalonSRX leftTalon0;
    public final WPI_TalonSRX leftTalon1;
    public final WPI_TalonSRX rightTalon0;
    public final WPI_TalonSRX rightTalon1;

    public SpeedControllerGroup leftSide;
    public SpeedControllerGroup rightSide;

    private final DifferentialDrive drive;

    private boolean slow = true;

    public DriveTrainSubsystem()
    {

        leftTalon0 = new WPI_TalonSRX(RobotMap.Motor.LEFT_TALON_0);
        leftTalon1 = new WPI_TalonSRX(RobotMap.Motor.LEFT_TALON_1);
        rightTalon0 = new WPI_TalonSRX(RobotMap.Motor.RIGHT_TALON_0);
        rightTalon1 = new WPI_TalonSRX(RobotMap.Motor.RIGHT_TALON_1);

        leftSide = new SpeedControllerGroup(leftTalon0, leftTalon1);
        rightSide = new SpeedControllerGroup(rightTalon0, rightTalon1);

        drive = new DifferentialDrive(leftSide, rightSide);

        drive.setDeadband(0.05);
        drive.setSafetyEnabled(true);
        drive.setMaxOutput(0.5);
    }

    @Override
    protected void initDefaultCommand() { setDefaultCommand(new DriveCommand()); }

    public void drive()
    {
        drive.arcadeDrive(OI.JOYSTICK.getX(), OI.JOYSTICK.getY(), true);
    }


    public void toggleSpeed()
    {
        if (slow)
        {
            drive.setMaxOutput(1.0);
            slow = false;
        }

        else
        {
            drive.setMaxOutput(0.5);
            slow = true;
        }
    }

    public void runMotors(double rightSpeed, double leftSpeed)
    {
        drive.tankDrive(rightSpeed, leftSpeed);
    }

    public void stop()
    {
        drive.stopMotor();
    }

    @SuppressWarnings("WeakerAccess")
    public static class Pair<L, R>
    {
        public L left;
        public R right;

        private String nameL;
        private String nameR;

        public Pair(L left, R right)
        {
            this.left = left;
            this.right = right;
            this.nameL = left.getClass().getSimpleName();
            this.nameR = right.getClass().getSimpleName();
        }

        public Pair() {}

        @Override
        public String toString()
        {
            return new StringBuilder(100 + nameL.length() + nameR.length()).append("Pair<").append(nameL).append(',')
                    .append(nameR).append("> { \"left\": \"").append(left).append("\", \"right\": \"").append(right)
                    .append("\" }").toString();
        }

        @Override
        public int hashCode() { return left.hashCode() * 13 + (right == null ? 0 : right.hashCode()); }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) { return true; }
            if (o instanceof Pair)
            {
                Pair pair = (Pair) o;
                return (left != null ? left.equals(pair.left) : pair.left == null)
                        && (left != null ? left.equals(pair.left) : pair.left == null);
            }
            return false;
        }
    }
}