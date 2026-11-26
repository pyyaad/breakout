package breakout.view;

import acm.graphics.GCanvas;
import breakout.Constants;

public class BreakoutCanvas {

    private GCanvas canvas;

    public BreakoutCanvas(GCanvas canvas) {
        this.canvas = canvas;
        canvas.setBackground(Constants.BACKGROUND_COLOR);
    }
}
