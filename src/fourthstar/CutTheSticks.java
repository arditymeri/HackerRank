package fourthstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * You are given a number of sticks of varying lengths. You will iteratively cut the sticks into smaller sticks,
 * discarding the shortest pieces until there are none left. At each iteration you will determine the length of
 * the shortest stick remaining, cut that length from each of the longer sticks and then discard all the pieces of
 * that shortest length. When all the remaining sticks are the same length, they cannot be shortened so discard them.
 * <p>
 * Given the lengths of n sticks, print the number of sticks that are left before each iteration until
 * there are none left.
 * <p>
 * #Easy
 */
public class CutTheSticks {

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        List<Integer> reducedValues = new ArrayList<>(arr);
        while (!reducedValues.isEmpty()) {
            result.add(reducedValues.size());
            int min = reducedValues.stream().min(Integer::compareTo).orElse(0);
            reducedValues = reducedValues.stream()
                    .map(value -> value - min)
                    .filter(value -> value > 0)
                    .collect(Collectors.toList());
        }
        return result;
    }

    public static void main(String[] args) {
//        List<Integer> result = cutTheSticks(Arrays.asList(1, 2, 3));
        List<Integer> result = cutTheSticks(Arrays.asList(1, 2, 3, 4, 3, 3, 2, 1));
        String value = result.stream().map(Objects::toString).collect(Collectors.joining("\n"));
        System.out.println(value);

    }
}
