package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumberComparatorTest {

    private NumberComparator comparator;

    @Before
    public void setUp() {
        comparator = new NumberComparator();
    }
    
    @Test
    public void should_return_4A0B_when_given_the_same_number() {
        String firstNumber = "1234";
        String secondNumber = "1234";

        String result = comparator.compare(firstNumber, secondNumber);

        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_return_0A0B_when_given_the_total_different_number() {
        String firstNumber = "1234";
        String secondNumber = "5678";

        String result = comparator.compare(firstNumber, secondNumber);

        assertThat(result, is("0A0B"));
    }

    @Test
    public void should_return_0A4B_when_given_two_number_with_same_character_but_all_at_different_index() {
        String firstNumber = "1234";
        String secondNUmber = "4321";

        String result = comparator.compare(firstNumber, secondNUmber);

        assertThat(result, is("0A4B"));
    }

    @Test
    public void should_return_2A2B_when_given_two_number_with_same_character_two_at_same_index_two_not() {
        String firstNumber = "1234";
        String secondNumber = "1243";

        String result = comparator.compare(firstNumber, secondNumber);

        assertThat(result, is("2A2B"));
    }
}
