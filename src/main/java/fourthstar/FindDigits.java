package fourthstar;

public class FindDigits {

    public static int findDigits(int n) {
        int digits = 0;
        int t = n;
        while (t > 0) {
            int digit = t % 10;
            if (digit != 0 && n % digit == 0) {
                digits++;
            }
            t /= 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        int result = findDigits(120);
        System.out.println(result);
    }
}
