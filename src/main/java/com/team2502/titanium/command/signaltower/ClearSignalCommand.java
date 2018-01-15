//package com.team2502.titanium.command.signaltower;
//
//import edu.wpi.first.wpilibj.command.Command;
//import com.team2502.titanium.Robot;
//import com.team2502.titanium.subsystem.SignalTowerSubsystem;
//
//public class ClearSignalCommand extends Command
//{
//    private SignalTowerSubsystem signalTower;
//     
//    public ClearSignalCommand()
//    {
//        requires(Robot.SIGNAL_TOWER);
//        signalTower = Robot.SIGNAL_TOWER;
//    }
//
//    @Override
//    protected void initialize() {}
//
//    @Override
//    protected void execute() { signalTower.switchColor_C(); }
//
//    @Override
//    protected boolean isFinished() { return true; }
//
//    @Override
//    protected void end() {}
//
//    @Override
//    protected void interrupted() {}
//}