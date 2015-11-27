package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

public class GuessGameTest {

    private NumberComparator comparator;
    private NumberGenerator generator;
    private PrintStream output;

    @Before
    public void setUp() {
        output = mock(System.out.getClass());
        generator = mock(NumberGenerator.class);
        comparator = spy(NumberComparator.class);
    }

    @Test(expected = NoSuchElementException.class)
    public void should_print_welcome_and_generate_number_when_game_start() {
        InputStream input = mock(System.in.getClass());
        GuessGame guess = new GuessGame(input, output, generator, comparator);
        when(generator.generate()).thenReturn("1234");

        guess.start();

        verify(generator, only()).generate();
        verify(output).println("Welcome!");
    }


    @Test
    public void should_print_rest_count_note_and_round_result_when_guess_input() throws IOException {
        //all i want to say is basically In Unit Test, one test should not depend on another test
        //em..maybe the following codes don't violate this low..
        InputStream input = new ByteArrayInputStream("1234\n".getBytes());
        GuessGame guess = new GuessGame(input, output, generator, comparator);
        when(generator.generate()).thenReturn("1234");
        guess.start();

        verify(output).println("Please input your number(6):");
        verify(comparator, only()).compare(anyString(), anyString());
        verify(output).println("Congratulations!");
    }
}
