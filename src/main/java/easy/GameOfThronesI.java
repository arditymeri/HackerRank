package easy;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameOfThronesI {

    public static String gameOfThrones(String s) {
        Map<Character, Long> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int length = s.length();
        if (length % 2 == 0) {
            boolean allEven = map.values()
                    .stream()
                    .allMatch(v -> v%2 == 0);
            return allEven ? "YES" : "NO";
        } else {
            boolean singleOdd = map.values()
                    .stream()
                    .mapToLong(v -> v%2)
                    .sum() == 1;
            return singleOdd ? "YES" : "NO";
        }
    }

    public static void main(String[] args) {
        String r1 = gameOfThrones("aaabbbb");
        String r2 = gameOfThrones("cdefghmnopqrstuvw");
        String r3 = gameOfThrones("cdcdcdcdeeeef");

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}
