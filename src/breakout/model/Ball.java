package breakout.model;

public class Ball {

    // x and y: top-left corner of the bounding box
    private double x;
    private double y;
    private double radius;

    public Ball(double radius) {
        this.radius = radius;
    }

    public void placeOnPaddle(Paddle paddle) {
        x = paddle.getX() + paddle.getWidth() / 2 - radius;
        y = paddle.getY() - 2 * radius;
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
