package model.dungeon.rooms.roomgenerators.randomized;

import java.util.Random;

public class RandomInteger {

    private static final Random random = new Random();
    private static final int DEFAULT_MAX_VALUE = 100;

    /**
     * Return a random int between 0 and the maximum value (excluded).
     * @param maxValue the max value (excluded) of the int expected.
     * @return a random int between 0 and the maximum value (excluded).
     */
    public static int getRandomInt(int maxValue) {
        return random.nextInt(maxValue);
    }

    public static boolean randomIntIsBelow(int threshold) {
        return getRandomInt(DEFAULT_MAX_VALUE) < threshold;
    }
}
