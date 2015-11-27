package io.github.uazw;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @Before
    public void setUp() {
        numberGenerator = new NumberGenerator(new Random());
    }

    @Test
    public void should_return_four_numbers() {

        String number = numberGenerator.generate();

        assertTrue(Pattern.matches("\\d{4}", number));
    }

    @Test
    public void should_return_four_distinct_number() {

        String number = numberGenerator.generate();

        long distinctNumbersCount = number.chars().distinct().count();
        assertThat(distinctNumbersCount, is(4L));
    }

    @Test
    public void should_return_four_different_number() {

        Set<String> numbers = new HashSet<>(4);
        for (int i = 0; i < 4; i++) {
            numbers.add(numberGenerator.generate());
        }

        long differentCount = numbers.stream().count();
        assertThat(differentCount, is(4L));
    }
}