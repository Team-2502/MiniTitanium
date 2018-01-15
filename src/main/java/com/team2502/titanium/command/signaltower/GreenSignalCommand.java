package com.team2502.titanium.command.signaltower;

import com.team2502.titanium.Robot;
import com.team2502.titanium.subsystem.SignalTowerSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class GreenSignalCommand extends Command
{
    private SignalTowerSubsystem signalTower;

    public GreenSignalCommand()
    {
        requires(Robot.SIGNAL_TOWER);
        signalTower = Robot.SIGNAL_TOWER;
    }

    @Override
    protected void initialize() { signalTower.switchColor_R(); }

    @Override
    protected void execute() { signalTower.switchColor_G(); }

    @Override
    protected boolean isFinished() { return true; }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {}
}