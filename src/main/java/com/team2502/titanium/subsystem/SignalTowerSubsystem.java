package com.team2502.titanium.subsystem;

import com.team2502.titanium.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

@SuppressWarnings({"WeakerAccess", "unused"})
public class SignalTowerSubsystem extends Subsystem
{
    public final Solenoid LIGHT_R;
    public final Solenoid LIGHT_A;
    public final Solenoid LIGHT_G;
//    public final Solenoid LIGHT_B;
//    public final Solenoid LIGHT_C;
    public final Solenoid SOUND_1;
    public final Solenoid SOUND_2;

    private boolean signalEnabled_R = true;
    private boolean signalEnabled_A = false;
    private boolean signalEnabled_G = false;
//    private boolean signalEnabled_B = false;
//    private boolean signalEnabled_C = false;
    private boolean signalEnabled_S1 = false;
    private boolean signalEnabled_S2 = false;

    public SignalTowerSubsystem()
    {
        this.LIGHT_R = new Solenoid(RobotMap.Solenoid.SIGNAL_LIGHT_R);
        this.LIGHT_A = new Solenoid(RobotMap.Solenoid.SIGNAL_LIGHT_A);
        this.LIGHT_G = new Solenoid(RobotMap.Solenoid.SIGNAL_LIGHT_G);
//        this.LIGHT_B = new Solenoid(RobotMap.Solenoid.SIGNAL_LIGHT_B);
//        this.LIGHT_C = new Solenoid(RobotMap.Solenoid.SIGNAL_LIGHT_C);
        this.SOUND_1 = new Solenoid(RobotMap.Solenoid.SIGNAL_SOUND_1);
        this.SOUND_2 = new Solenoid(RobotMap.Solenoid.SIGNAL_SOUND_2);
    }

    @Override
    protected void initDefaultCommand() {}

    // Red
    public void switchColor_R() { this.setColor_R(this.signalEnabled_R = !this.signalEnabled_R); }

    public void setColor_R(boolean signalEnabled_R) { this.LIGHT_R.set(signalEnabled_R); }

    // Amber
    public void switchColor_A() { this.setColor_A(this.signalEnabled_A = !this.signalEnabled_A); }

    public void setColor_A(boolean signalEnabled_A) { this.LIGHT_A.set(signalEnabled_A); }

    // Green
    public void switchColor_G() { this.setColor_G(this.signalEnabled_G = !this.signalEnabled_G); }

    public void setColor_G(boolean signalEnabled_G) { this.LIGHT_G.set(signalEnabled_G); }

//    // Blue
//    public void switchColor_B() { this.setColor_B(this.signalEnabled_B = !this.signalEnabled_B); }
//
//    public void setColor_B(boolean signalEnabled_B) { this.LIGHT_B.set(signalEnabled_B); }
//
//    // Clear
//    public void switchColor_C() { this.setColor_C(this.signalEnabled_C = !this.signalEnabled_C); }
//
//    public void setColor_C(boolean signalEnabled_C) { this.LIGHT_C.set(signalEnabled_C); }

    // Sound 1
    public void switchSound_1() { this.setSound_1(this.signalEnabled_S1 = !this.signalEnabled_S1); }

    public void setSound_1(boolean signalEnabled_S1) { this.SOUND_1.set(signalEnabled_S1); }

    // Sound 2
    public void switchSound_2() { this.setSound_2(this.signalEnabled_S2 = !this.signalEnabled_S2); }

    public void setSound_2(boolean signalEnabled_S2) { this.SOUND_2.set(signalEnabled_S2); }
}