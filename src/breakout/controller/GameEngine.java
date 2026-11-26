package breakout.controller;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

import acm.program.GraphicsProgram;
import breakout.Constants;
import breakout.model.Paddle;
import breakout.view.BreakoutCanvas;

public class GameEngine extends GraphicsProgram {

    private BreakoutCanvas breakoutCanvas;
    private Paddle paddle;

    public void init() {
        getGCanvas().setPreferredSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
        breakoutCanvas = new BreakoutCanvas(getGCanvas());

        double paddleX = (Constants.CANVAS_WIDTH - Constants.PADDLE_WIDTH) / 2.0;
        paddle = new Paddle(paddleX, Constants.PADDLE_Y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
    }

    public void run() {
        // pack here: ACM adds menu bar after init()
        SwingUtilities.getWindowAncestor(getGCanvas()).pack();

        while (true) {
            updateGame();
            breakoutCanvas.render(paddle);
            pause(Constants.FRAME_DELAY);
        }
    }

    private void updateGame() {
    }
}
