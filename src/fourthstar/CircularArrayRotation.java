package fourthstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CircularArrayRotation {

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int length = a.size();
        int offset = k % length;
        List<Integer> newValues = new ArrayList<>();
        for (Integer q : queries) {
            int index = q - offset;
            if (index < 0) {
                index = length - 1 - (offset - (q + 1));
            }
            newValues.add(a.get(index));
        }
        return newValues;
    }

    public static void main(String[] args) {
//        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> a = Arrays.asList(1, 2, 3);
        int k = 2;
        List<Integer> q = Arrays.asList(0, 1, 2);
        List<Integer> shifted = circularArrayRotation(a, k, q);
        String newValues = shifted.stream().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(newValues);

    }
}
