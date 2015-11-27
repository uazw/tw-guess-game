package io.github.uazw;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        GuessGame guessGame = new GuessGame(System.in, System.out,
                new NumberGenerator(new Random()), new NumberComparator());

        guessGame.start();
    }
}
