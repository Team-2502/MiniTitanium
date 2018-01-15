package com.team2502.titanium.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.team2502.titanium.OI;
import com.team2502.titanium.RobotMap;
import com.team2502.titanium.command.DriveCommand;
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
    private final DifferentialDrive drive;
    public double leftSpeed;
    public double rightSpeed;
    public int millisecondsToRunTL = 1000;
    public int millisecondsToRunTR = 1000;
    public SpeedControllerGroup leftSide;
    public SpeedControllerGroup rightSide;
    public int m = 1000;
    private double lastLeft;
    private double lastRight;

    public DriveTrainSubsystem()
    {
        lastLeft = 0.0D;
        lastRight = 0.0D;

        leftTalon0 = new WPI_TalonSRX(RobotMap.Motor.LEFT_TALON_0);
        leftTalon1 = new WPI_TalonSRX(RobotMap.Motor.LEFT_TALON_1);
        rightTalon0 = new WPI_TalonSRX(RobotMap.Motor.RIGHT_TALON_0);
        rightTalon1 = new WPI_TalonSRX(RobotMap.Motor.RIGHT_TALON_1);

        leftSide = new SpeedControllerGroup(leftTalon0, leftTalon1);
        rightSide = new SpeedControllerGroup(rightTalon0, rightTalon1);

        drive = new DifferentialDrive(leftSide, rightSide);
    }

    public void setTeleopSettings(WPI_TalonSRX talon)
    {
        talon.configNominalOutputReverse(0.0d, 10);
        talon.set(ControlMode.PercentOutput, 0.0d);
    }

    @Override
    protected void initDefaultCommand() { setDefaultCommand(new DriveCommand()); }

    private Pair<Double, Double> getSpeedArcade(Pair<Double, Double> out)
    {
        double yLevel = -OI.JOYSTICK.getY();

        double xLevel = OI.JOYSTICK.getX();

        if (Math.abs(yLevel) < 0.005D) { yLevel = 0.0D; }

        if (Math.abs(xLevel) < 0.005D) { xLevel = 0.0D; }

        out.left = xLevel;
        out.right = yLevel;
        return out;
    }

    private Pair<Double, Double> getSpeedArcade() { return getSpeedArcade(SPEED_CONTAINER); }

    public void drive()
    {
        Pair<Double, Double> speed = getSpeedArcade();
        drive.arcadeDrive(speed.left, speed.right);
    }

    public void runMotors(double x, double y)
    {
        leftSpeed = x;
        rightSpeed = y;
        leftTalon0.set(ControlMode.Current, x);
        leftTalon1.set(ControlMode.Current, x);
        rightTalon0.set(ControlMode.Current, y);
        rightTalon1.set(ControlMode.Current, y);
    }

    public void stopDriveS()
    {
        leftTalon0.set(ControlMode.Current, 0);
        leftTalon1.set(ControlMode.Current, 0);
        rightTalon0.set(ControlMode.Current, 0);
        rightTalon1.set(ControlMode.Current, 0);
    }

    public void stop()
    {
        lastLeft = 0.0D;
        lastRight = 0.0D;
        drive.tankDrive(0.0D, 0.0D);
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