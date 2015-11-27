package io.github.uazw;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberGenerator {

    private final Random random;

    public NumberGenerator(Random random) {
        this.random = random;
    }

    public String generate() {
        Set<Integer> integers = new LinkedHashSet<>(4);
        do {
            integers.add(random.nextInt(10));
        } while (integers.size() != 4);
        return integers.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
