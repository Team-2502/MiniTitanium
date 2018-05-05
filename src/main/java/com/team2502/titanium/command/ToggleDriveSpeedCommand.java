package com.team2502.titanium.command;

import com.team2502.titanium.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleDriveSpeedCommand extends InstantCommand
{
    public ToggleDriveSpeedCommand()
    {
        Robot.DRIVE_TRAIN.toggleSpeed();
    }
}
