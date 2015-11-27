package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RoundTest {

    public static final String TEST_NUMBER = "1234";
    private NumberComparator comparator;

    @Before
    public void setUp() {
        comparator = spy(NumberComparator.class);
    }

    @Test
    public void should_return_congratulation_when_match_not_last() {

        Round round = new Round(TEST_NUMBER, comparator, false);
        String result = round.run("1234");

        verify(comparator, only()).compare(anyString(), anyString());
        assertTrue(round.isSuccess());
        assertThat(result, is("Congratulations!"));
    }

    @Test
    public void should_return_notice_when_mismatch_but_not_at_last_round() {

        Round round = new Round(TEST_NUMBER, comparator, false);
        String result = round.run("4321");

        verify(comparator, only()).compare(anyString(), anyString());
        assertFalse(round.isSuccess());
        assertEquals(result, "0A4B");
    }

    @Test
    public void should_return_game_over_when_last_round_mismatch() {

        Round round = new Round(TEST_NUMBER, comparator, true);
        String result = round.run("4321");

        verify(comparator, only()).compare(anyString(), anyString());
        assertFalse(round.isSuccess());
        assertEquals(result, "Game Over");
    }

    @Test
    public void should_return_duplicate_note_when_have_duplication() {

        Round round = new Round(TEST_NUMBER, comparator, true);
        String result = round.run("1123");

        verify(comparator, never()).compare(anyString(), anyString());
        assertFalse(round.isSuccess());
        assertEquals(result, "Cannot input duplicate numbers!");
    }

    @Test
    public void should_return_congratulation_even_last_round() {

        Round round = new Round(TEST_NUMBER, comparator, true);
        String result = round.run("1234");

        verify(comparator, only()).compare(anyString(), anyString());
        assertTrue(round.isSuccess());
        assertEquals(result, "Congratulations!");

    }
}

