package org.improving.tag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();

        long elapsedTicks = game.getEndTime().getTime() - game.getStartTime().getTime();
        double elapsedSeconds = elapsedTicks / 1000.0;
        System.out.println("We were running for " + elapsedSeconds + "s.");
    }
}