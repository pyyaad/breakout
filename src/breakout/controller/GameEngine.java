package breakout.controller;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import acm.program.GraphicsProgram;
import breakout.Constants;
import breakout.model.Ball;
import breakout.model.Paddle;
import breakout.view.BreakoutCanvas;

public class GameEngine extends GraphicsProgram {

    private BreakoutCanvas breakoutCanvas;
    private Paddle paddle;
    private Ball ball;
    private boolean leftPressed;
    private boolean rightPressed;

    public void init() {
        getGCanvas().setPreferredSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
        breakoutCanvas = new BreakoutCanvas(getGCanvas());

        double paddleX = (Constants.CANVAS_WIDTH - Constants.PADDLE_WIDTH) / 2.0;
        paddle = new Paddle(paddleX, Constants.PADDLE_Y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
        ball = new Ball(Constants.BALL_RADIUS);

        addKeyListeners();
    }

    public void run() {
        // pack here: ACM adds menu bar after init()
        SwingUtilities.getWindowAncestor(getGCanvas()).pack();
        // focus: keys work without clicking the window first
        getGCanvas().requestFocusInWindow();

        while (true) {
            updateGame();
            breakoutCanvas.render(paddle, ball);
            pause(Constants.FRAME_DELAY);
        }
    }

    private void updateGame() {
        if (leftPressed) {
            paddle.moveLeft();
        }
        if (rightPressed) {
            paddle.moveRight();
        }
        ball.placeOnPaddle(paddle);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }
}
