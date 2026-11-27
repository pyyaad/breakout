package breakout.model;

import breakout.Constants;

public class Ball {

    // x and y: top-left corner of the bounding box
    private double x;
    private double y;
    private double radius;
    private double dx;
    private double dy;

    public Ball(double radius) {
        this.radius = radius;
    }

    public void placeOnPaddle(Paddle paddle) {
        x = paddle.getX() + paddle.getWidth() / 2 - radius;
        y = paddle.getY() - 2 * radius;
    }

    public void launch() {
        dx = Constants.BALL_START_DX;
        dy = Constants.BALL_START_DY;
    }

    public void move() {
        x = x + dx;
        y = y + dy;
    }

    // snap back to the wall so the ball cannot stick outside
    public void bounceOffWalls() {
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + 2 * radius > Constants.CANVAS_WIDTH) {
            x = Constants.CANVAS_WIDTH - 2 * radius;
            dx = -dx;
        }
        if (y < Constants.HUD_HEIGHT) {
            y = Constants.HUD_HEIGHT;
            dy = -dy;
        }
    }

    public boolean isBelowCanvas() {
        return y > Constants.CANVAS_HEIGHT;
    }

    // AABB collision: the two boxes overlap
    public boolean isTouching(Paddle paddle) {
        double ballLeft = x;
        double ballRight = x + 2 * radius;
        double ballTop = y;
        double ballBottom = y + 2 * radius;

        double paddleLeft = paddle.getX();
        double paddleRight = paddle.getX() + paddle.getWidth();
        double paddleTop = paddle.getY();
        double paddleBottom = paddle.getY() + paddle.getHeight();

        return ballLeft < paddleRight
                && ballRight > paddleLeft
                && ballTop < paddleBottom
                && ballBottom > paddleTop;
    }

    // angle bounce: hit position decides direction
    public void bounceOffPaddle(Paddle paddle) {
        double ballCenter = x + radius;
        double paddleCenter = paddle.getX() + paddle.getWidth() / 2;
        double offset = (ballCenter - paddleCenter) / (paddle.getWidth() / 2);
        if (offset > 1) {
            offset = 1;
        }
        if (offset < -1) {
            offset = -1;
        }

        double angle = offset * Math.toRadians(Constants.MAX_BOUNCE_ANGLE);
        double speed = Math.hypot(dx, dy);
        dx = speed * Math.sin(angle);
        dy = -Math.abs(speed * Math.cos(angle));
        y = paddle.getY() - 2 * radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDy() {
        return dy;
    }

    public double getRadius() {
        return radius;
    }
}
