package fourthstar;

import java.math.BigInteger;

public class ExtraLongFactorial {

    public static void extraLongFactorials(int n) {
        BigInteger bigInteger = BigInteger.valueOf(n);
        BigInteger factorial = BigInteger.ONE;
        while (n > 0) {
            factorial = factorial.multiply(bigInteger);
            bigInteger = bigInteger.subtract(BigInteger.ONE);
            n--;
        }
        System.out.println(factorial.toString());
    }

    public static void main(String[] args) {
        extraLongFactorials(21);
    }
}
