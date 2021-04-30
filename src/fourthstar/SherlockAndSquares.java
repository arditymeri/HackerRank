package fourthstar;

/**
 * Watson likes to challenge Sherlock's math ability. He will provide a starting and ending value that describe a range
 * of integers, inclusive of the endpoints. Sherlock must determine the number of square integers within that range.
 */
public class SherlockAndSquares {

    public static int squares(int a, int b) {
        int n = 0;
        double root = Math.sqrt(a);
        double rounded = Math.ceil(root);
        for (int i = (int)rounded; i <= Math.sqrt(b); i++) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        int result = squares(50, 55);
        System.out.println(result);
    }
}
