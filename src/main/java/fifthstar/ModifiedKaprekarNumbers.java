package fifthstar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ModifiedKaprekarNumbers {

    public static void kaprekarNumbers(int p, int q) {
        String toPrint = IntStream.range(p, q)
                .filter(ModifiedKaprekarNumbers::isKaprekarNumber)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(toPrint);
    }

    public static boolean isKaprekarNumber(int p) {
        int numDigits = findNumDigits(p);
        int squared = p * p;
        int d = (int) Math.pow(10, numDigits);
        int r = squared % d;
        int l = squared / d;
        return l + r == p;
    }

    public static int findNumDigits(int p) {
        int n = 1;
        int k = p / 10;
        while (k > 0) {
            k /= 10;
            n++;
        }
        return n;
    }
}
