package io.github.uazw;

public class NumberComparator {

    public String compare(String firstNumber, String secondNumber) {
        int aCount = 0;
        int sameNumber = 0;
        for (int i = 0; i < secondNumber.length(); i++) {
            char current = secondNumber.charAt(i);
            if (current == firstNumber.charAt(i)) aCount++;
            if (firstNumber.indexOf(current) != -1) sameNumber++;
        }
        return aCount + "A" + (sameNumber - aCount) + "B";
    }
}
