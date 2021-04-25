package rdstar;

import java.util.function.Function;
import java.util.stream.Stream;

public class UtopianTree {

    public static int utopianTree(int n) {
        Function<Integer, Integer> inc = i -> i + 1;
        Function<Integer, Integer> dup = i -> i * 2;

        return Stream.iterate(1, i -> i + 1)
                .limit(n)
                .map(i -> {return i%2 == 1 ? dup:inc;})
                .reduce(Function.identity(), Function::andThen)
                .apply(1);
    }

    public static void main(String[] args) {
        int height = utopianTree(5);
        System.out.println(height);
    }
}
