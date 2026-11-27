package breakout.view;

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import breakout.Constants;
import breakout.model.Ball;
import breakout.model.Paddle;

public class BreakoutCanvas {

    private GCanvas canvas;
    private GRect hudBar;
    private GLabel livesLabel;
    private GRect paddleRect;
    private GOval ballOval;

    public BreakoutCanvas(GCanvas canvas) {
        this.canvas = canvas;
        canvas.setBackground(Constants.BACKGROUND_COLOR);

        hudBar = new GRect(0, 0, Constants.CANVAS_WIDTH, Constants.HUD_HEIGHT);
        hudBar.setFilled(true);
        hudBar.setColor(Constants.HUD_COLOR);
        canvas.add(hudBar);

        livesLabel = new GLabel("Lives: " + Constants.START_LIVES);
        livesLabel.setFont(Constants.HUD_FONT);
        livesLabel.setColor(Constants.HUD_TEXT_COLOR);
        // baseline: centers the text vertically in the bar
        double labelY = (Constants.HUD_HEIGHT + livesLabel.getAscent()) / 2;
        canvas.add(livesLabel, Constants.HUD_TEXT_MARGIN, labelY);

        paddleRect = new GRect(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
        paddleRect.setFilled(true);
        paddleRect.setColor(Constants.PADDLE_COLOR);
        canvas.add(paddleRect);

        ballOval = new GOval(2 * Constants.BALL_RADIUS, 2 * Constants.BALL_RADIUS);
        ballOval.setFilled(true);
        ballOval.setColor(Constants.BALL_COLOR);
        canvas.add(ballOval);
    }

    public void render(Paddle paddle, Ball ball, int lives) {
        paddleRect.setLocation(paddle.getX(), paddle.getY());
        ballOval.setLocation(ball.getX(), ball.getY());
        livesLabel.setLabel("Lives: " + lives);
    }
}
