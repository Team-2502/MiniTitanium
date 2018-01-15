package com.team2502.titanium;

@SuppressWarnings({"WeakerAccess"})
public class RobotMap
{
    public static final int UNDEFINED = -1;

    private RobotMap() {}

    public static final class Joystick
    {
        public static final int JOYSTICK = 0;

        private Joystick() {}

        public static final class Button
        {
            private Button() {}
        }
    }

    public static final class Electrical {}

    public static final class Motor
    {
        public static final int LEFT_TALON_0 = 1;
        public static final int LEFT_TALON_1 = 2;
        public static final int RIGHT_TALON_0 = 3;
        public static final int RIGHT_TALON_1 = 4;

        private Motor() {}
    }

    public static final class Solenoid
    {
        // Signal Tower
        public static final int SIGNAL_LIGHT_R = 7;
        public static final int SIGNAL_LIGHT_A = 6;
        public static final int SIGNAL_LIGHT_G = 5;
//    	public static final int SIGNAL_LIGHT_B = 4;
//    	public static final int SIGNAL_LIGHT_C = 3;
        public static final int SIGNAL_SOUND_1 = 2;
        public static final int SIGNAL_SOUND_2 = 1;

        private Solenoid() {}
    }
}
