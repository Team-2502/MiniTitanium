package com.team2502.titanium;

import com.team2502.titanium.subsystem.DriveTrainSubsystem;
import com.team2502.titanium.subsystem.SignalTowerSubsystem;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class Robot extends IterativeRobot
{
    public static DriveTrainSubsystem DRIVE_TRAIN;
    public static SignalTowerSubsystem SIGNAL_TOWER;

    public void robotInit()
    {
        DRIVE_TRAIN = new DriveTrainSubsystem();
        SIGNAL_TOWER = new SignalTowerSubsystem();
        OI.init();
    }

    @Override
    public void disabledInit()
    {
        super.disabledPeriodic();
    }

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() { Scheduler.getInstance().run(); }
}