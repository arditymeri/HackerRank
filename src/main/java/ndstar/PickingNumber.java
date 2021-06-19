package ndstar;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of integers, find the longest subarray where the absolute difference between
 * any two elements is less than or equal to .
 */
public class PickingNumber {

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Map<Integer, Long> map = a.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long max = 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            Integer key = entry.getKey();
            long current = entry.getValue();
            long less = map.getOrDefault(key - 1, 0L);
            max = Math.max(max, current + less);
            long more = map.getOrDefault(key + 1, 0L);
            max = Math.max(max, current + more);

        }
        return (int) max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 1, 2);
        int result = pickingNumbers(numbers);
        System.out.println(result);
    }
}
