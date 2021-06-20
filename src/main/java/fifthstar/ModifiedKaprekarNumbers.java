package fifthstar;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ModifiedKaprekarNumbers {

    public static void kaprekarNumbers(int p, int q) {
        String toPrint = IntStream.range(p, q + 1)
                .filter(ModifiedKaprekarNumbers::isKaprekarNumber)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        toPrint = toPrint.isEmpty() ? "INVALID RANGE" : toPrint;
        System.out.println(toPrint);
    }

    public static boolean isKaprekarNumber(int p) {
        int numDigits = findNumDigits(p);
        long squared = (long)p * p;
        int d = (int) Math.pow(10, numDigits);
        int r = (int) (squared % d);
        int l = (int) (squared / d);
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
