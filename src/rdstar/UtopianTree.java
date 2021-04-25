package rdstar;

import java.util.function.Function;

public class UtopianTree {

    public static int utopianTree(int n) {
        Function<Integer, Integer> inc = i -> i + 1;
        Function<Integer, Integer> dup = i -> i * 2;
        int height = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                height = dup.apply(height);
            } else {
                height = inc.apply(height);
            }
        }
        return height;
    }

    public static void main(String[] args) {
        int height = utopianTree(5);
        System.out.println(height);
    }
}
