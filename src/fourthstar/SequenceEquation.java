package fourthstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SequenceEquation {

    static int[] permutationEquation(int[] p) {
        List<Integer> values = Arrays.stream(p).boxed().collect(Collectors.toList());
        List<Integer> permutation = new ArrayList<>();
        for (int i = 1; i <= p.length; i++) {
            int p1 = values.indexOf(i) + 1;
            int p2 = values.indexOf(p1) + 1;
            permutation.add(p2);
        }
        int[] r = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            r[i] = permutation.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] p = {4, 3, 5, 1, 2}; // expected: 1, 3, 5, 4, 2
        int[] r = permutationEquation(p);
        String result = Arrays.stream(r).boxed().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(result);
    }
}
