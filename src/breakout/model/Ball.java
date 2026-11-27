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
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
    }

    public boolean isBelowCanvas() {
        return y > Constants.CANVAS_HEIGHT;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }
}
