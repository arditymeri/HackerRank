package rdstar;

import java.util.List;
import java.util.Optional;

/**
 * A video player plays a game in which the character competes in a hurdle race. Hurdles are of
 * varying heights, and the characters have a maximum height they can jump. There is a magic potion
 * they can take that will increase their maximum jump height by 1 unit for each dose. How many doses of
 * the potion must the character take to be able to jump all of the hurdles. If the character can already
 * clear all of the hurdles, return 0.
 */
public class HurdleRace {

    public static int hurdleRace(int k, List<Integer> height) {
        int max = height.stream().max(Integer::compareTo).orElse(k);
        return Math.max(0, max - k);
    }
}
