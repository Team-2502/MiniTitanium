package com.team2502.titanium.command.signaltower;

import com.team2502.titanium.Robot;
import com.team2502.titanium.subsystem.SignalTowerSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class Sound2SignalCommand extends Command
{
    private SignalTowerSubsystem signalTower;

    public Sound2SignalCommand()
    {
        requires(Robot.SIGNAL_TOWER);
        signalTower = Robot.SIGNAL_TOWER;
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() { signalTower.switchSound_2(); }

    @Override
    protected boolean isFinished() { return true; }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {}
}