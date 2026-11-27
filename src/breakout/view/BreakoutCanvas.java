package breakout.view;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.graphics.GRect;
import breakout.Constants;
import breakout.model.Ball;
import breakout.model.Paddle;

public class BreakoutCanvas {

    private GCanvas canvas;
    private GRect paddleRect;
    private GOval ballOval;

    public BreakoutCanvas(GCanvas canvas) {
        this.canvas = canvas;
        canvas.setBackground(Constants.BACKGROUND_COLOR);

        paddleRect = new GRect(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
        paddleRect.setFilled(true);
        paddleRect.setColor(Constants.PADDLE_COLOR);
        canvas.add(paddleRect);

        ballOval = new GOval(2 * Constants.BALL_RADIUS, 2 * Constants.BALL_RADIUS);
        ballOval.setFilled(true);
        ballOval.setColor(Constants.BALL_COLOR);
        canvas.add(ballOval);
    }

    public void render(Paddle paddle, Ball ball) {
        paddleRect.setLocation(paddle.getX(), paddle.getY());
        ballOval.setLocation(ball.getX(), ball.getY());
    }
}
