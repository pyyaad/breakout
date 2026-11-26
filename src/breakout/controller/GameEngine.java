package breakout.controller;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

import acm.program.GraphicsProgram;
import breakout.Constants;
import breakout.view.BreakoutCanvas;

public class GameEngine extends GraphicsProgram {

    private BreakoutCanvas breakoutCanvas;

    public void init() {
        getGCanvas().setPreferredSize(new Dimension(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT));
        breakoutCanvas = new BreakoutCanvas(getGCanvas());
    }

    public void run() {
        // ACM adds its menu bar after init(), so the window is packed here to fit the canvas size
        SwingUtilities.getWindowAncestor(getGCanvas()).pack();

        while (true) {
            updateGame();
            breakoutCanvas.render();
            pause(Constants.FRAME_DELAY);
        }
    }

    private void updateGame() {
    }
}
