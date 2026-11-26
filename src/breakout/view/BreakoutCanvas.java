package breakout.view;

import acm.graphics.GCanvas;
import acm.graphics.GRect;
import breakout.Constants;
import breakout.model.Paddle;

public class BreakoutCanvas {

    private GCanvas canvas;
    private GRect paddleRect;

    public BreakoutCanvas(GCanvas canvas) {
        this.canvas = canvas;
        canvas.setBackground(Constants.BACKGROUND_COLOR);

        paddleRect = new GRect(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
        paddleRect.setFilled(true);
        paddleRect.setColor(Constants.PADDLE_COLOR);
        canvas.add(paddleRect);
    }

    public void render(Paddle paddle) {
        paddleRect.setLocation(paddle.getX(), paddle.getY());
    }
}
