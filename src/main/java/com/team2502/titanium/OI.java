package com.team2502.titanium;

import com.team2502.titanium.command.signaltower.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

@SuppressWarnings("WeakerAccess")
public final class OI
{
    public static final Joystick JOYSTICK = new Joystick(RobotMap.Joystick.JOYSTICK);

    public static final Button RED_BUTTON = new JoystickButton(JOYSTICK, 1);
    public static final Button AMBER_BUTTON = new JoystickButton(JOYSTICK, 2);
    public static final Button GREEN_BUTTON = new JoystickButton(JOYSTICK, 3);
//    public static final Button BLUE_BUTTON = new JoystickButton(JOYSTICK, 4);
//    public static final Button CLEAR_BUTTON = new JoystickButton(JOYSTICK, 5);
    public static final Button SOUND1_BUTTON = new JoystickButton(JOYSTICK, 6);
    public static final Button SOUND2_BUTTON = new JoystickButton(JOYSTICK, 7);

    static
    {
        RED_BUTTON.whenPressed(new RedSignalCommand());
        AMBER_BUTTON.whenPressed(new AmberSignalCommand());
        GREEN_BUTTON.whenPressed(new GreenSignalCommand());
//        BLUE_BUTTON.whenPressed(new BlueSignalCommand());
//        CLEAR_BUTTON.whenPressed(new ClearSignalCommand());
        SOUND1_BUTTON.whenPressed(new Sound1SignalCommand());
        SOUND2_BUTTON.whenPressed(new Sound2SignalCommand());
    }

    private OI() {}

    public static void init() {}
}