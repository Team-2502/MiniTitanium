package com.team2502.titanium.command;

import com.team2502.titanium.Robot;
import com.team2502.titanium.subsystem.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command
{
    private final DriveTrainSubsystem driveTrainSubsystem;

    public DriveCommand()
    {
        requires(Robot.DRIVE_TRAIN);
        driveTrainSubsystem = Robot.DRIVE_TRAIN;
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute()
    {
        System.out.printf("Angle: %.2f\n",Robot.NAVX.getYaw());
        System.out.printf("Compass Heading: %.2f\n",Robot.NAVX.getCompassHeading());
        driveTrainSubsystem.drive();
    }

    @Override
    protected boolean isFinished() { return false; }

    @Override
    protected void end() { driveTrainSubsystem.stop(); }

    @Override
    protected void interrupted() { driveTrainSubsystem.stop(); }
}