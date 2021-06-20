package fifthstar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than
 * another string if it comes later in a lexicographically sorted list.
 * <p>
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 * <p>
 * It must be greater than the original word
 * It must be the smallest word that meets the first condition
 */
public class BiggerIsGreater {

    public static String biggerIsGreater(String w) {
        int leftMost = -1;
        int index = 0;

        for (int i = w.length() - 1; i >= 0; i--) {
            int firstLeftSideSmallerThan = findFirstFirstSmallerThan(w, i);
            if (firstLeftSideSmallerThan >= 0 && firstLeftSideSmallerThan > leftMost) {
                leftMost = firstLeftSideSmallerThan;
                index = i;
            }
        }
        if (leftMost >= 0) {
            String suffix = w.substring(leftMost, index) + w.substring(index + 1);
            String sortedSuffix = sortValue(suffix);
            String prefix = w.substring(0, leftMost);
            return prefix + w.charAt(index) + sortedSuffix;
        }
        return "no answer";
    }

    private static String sortValue(String suffix) {
        return suffix.chars()
                .mapToObj(c -> Character.toString((char) c))
                .sorted()
                .collect(Collectors.joining());
    }

    private static int findFirstFirstSmallerThan(String w, int index) {
        char key = w.charAt(index);
        for (int i = index - 1; i >= 0; i--) {
            char c = w.charAt(i);
            if (c < key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*
         *
         * "ab", "bb", "hefg", "dhck", "dkhc"
         * "lmno", "dcba", "dcbb", "abdc", "abcd", "fedcbabcd"
         */

        List<String> sample0 = Arrays.asList("ab", "bb", "hefg", "dhck", "dkhc");
        List<String> sample1 = Arrays.asList("lmno", "dcba", "dcbb", "abdc", "abcd", "fedcbabcd");
        System.out.println("#############################################");
        System.out.println("Sample 0:");
        sample0.stream().map(BiggerIsGreater::biggerIsGreater).forEach(System.out::println);
        System.out.println("#############################################");
        System.out.println("Sample 1:");
        sample1.stream().map(BiggerIsGreater::biggerIsGreater).forEach(System.out::println);

    }

}
