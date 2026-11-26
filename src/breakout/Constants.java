package breakout;

import java.awt.Color;

public class Constants {

    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 600;

    public static final Color BACKGROUND_COLOR = new Color(20, 20, 35);

    // 60 FPS: ms between frames
    public static final double FRAME_DELAY = 1000.0 / 60;

    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_HEIGHT = 15;
    public static final int PADDLE_Y = 545;
    public static final Color PADDLE_COLOR = new Color(230, 230, 240);
    public static final int PADDLE_SPEED = 8;
}
