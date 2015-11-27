package io.github.uazw;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GuessGame {
    private final NumberComparator comparator;
    private final Scanner input;
    private final PrintStream output;
    private final NumberGenerator generator;
    private String number;

    public GuessGame(InputStream input, PrintStream output,
                     NumberGenerator generator, NumberComparator comparator) {
        
        this.input = new Scanner(input);
        this.output = output;
        this.generator = generator;
        this.comparator = comparator;
    }

    public void start() {
        number =  generator.generate();
        output.println("Welcome!");
    }
}
