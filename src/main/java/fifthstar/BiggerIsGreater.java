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
    /*
     * hefg -> hegf
     * abcd -> abdc
     * 1234 -> 1243
     * 9475 -> 9547
     * 927846493 -> 932446789
     * 8674839 -> 8674893
     * 19892 -> 21899
     * 98971 -> 99871
     */
    public static String biggerIsGreater(String w) {
        // Write your code here
        for (int i = w.length() - 1; i >= 0; i--) {
            int firstLeftSideSmallerThan = findFirstFirstSmallerThan(w, i);
            if (firstLeftSideSmallerThan >= 0) {
                String suffix = w.substring(firstLeftSideSmallerThan, i) + w.substring(i + 1);
                String sortedSuffix = sortValue(suffix);
                String prefix = w.substring(0, firstLeftSideSmallerThan);
                return prefix + w.charAt(i) + sortedSuffix;
            }
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
