package breakout;

import breakout.controller.GameEngine;

public class Main {

    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        game.start(args);
    }
}
