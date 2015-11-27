package io.github.uazw;

public class Round {

    private final NumberComparator comparator;
    private final boolean isLast;
    private final String testNumber;
    private boolean success;

    public Round(String testNumber, NumberComparator comparator, boolean isLast) {
        this.testNumber = testNumber;
        this.comparator = comparator;
        this.isLast = isLast;
    }

    public String run(String userGuessNumber) {
        if (!haveDuplication(userGuessNumber)) {
            String result = comparator.compare(testNumber, userGuessNumber);
            if (result.equals("4A0B")) {
                this.success = true;
                return "Congratulations!";
            } else if (isLast) {
                this.success = false;
                return "Game Over";
            } else {
                this.success = false;
                return result;
            }
        } else {
            return "Cannot input duplicate numbers!";
        }

    }

    public boolean isSuccess() {
        return success;
    }

    private boolean haveDuplication(String str) {
        return str.length() != str.chars().distinct().count();
    }
}
