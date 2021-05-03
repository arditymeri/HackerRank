package fourthstar;

/**
 * There is a string, s, of lowercase English letters that is repeated infinitely many times. Given an integer, n,
 * find and print the number of letter a's in the first n letters of the infinite string.
 */
public class RepeatedString {

    public static long repeatedString(String s, long n) {
        // Write your code here
        long times = n / s.length();
        long remainder = n%s.length();
        final char a = 'a';
        long n1 = s.chars().filter(c -> c == a).count();
        long n2 = s.chars().limit(remainder).filter(c -> c == a).count();
        return times * n1 + n2;

    }

    public static void main(String[] args) {
//        long result = repeatedString("aba", 10);
        long result = repeatedString("a", 1000000000000L);
        System.out.println(result);
    }
}
