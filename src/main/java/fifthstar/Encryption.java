package fifthstar;

import java.util.ArrayList;
import java.util.List;

public class Encryption {

    /**
     * An English text needs to be encrypted using the following encryption scheme.
     * First, the spaces are removed from the text. Let L be the length of this text.
     * Then, characters are written into a grid, whose rows and columns have the following constraints:
     * <p>
     * {@code floor(L) <= row <= column <= ceil(L)}
     * <p>
     * The encoded message is obtained by displaying the characters of each column, with a space between column texts.
     * <p>
     * Why is this medium???
     *
     * @param s value to be encrypted.
     * @return the ecnrypted value.
     */
    public static String encryption(String s) {
        // Write your code here
        String squashed = s.replaceAll(" ", "");
        int l = squashed.length();
        double root = Math.sqrt(l);
        int columns = (int) Math.ceil(root);

        List<String> values = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            String value = findValuesAtPositions(squashed, i, columns);
            values.add(value);
        }
        return String.join(" ", values);
    }

    private static String findValuesAtPositions(String squashed, int i, int columns) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = i; j < squashed.length(); j += columns) {
            char c = squashed.charAt(j);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "if man was meant to stay on the ground god would have given us root";
        String result = encryption(s);
        System.out.println(result);

    }

}
