package fourthstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * John Watson knows of an operation called a right circular rotation on an array of integers.
 * One rotation operation moves the last array element to the first position and shifts all remaining elements
 * right one. To test Sherlock's abilities, Watson provides Sherlock with an array of integers.
 * Sherlock is to perform the rotation operation a number of times then determine the value of
 * the element at a given position.
 * <p>
 * For each array, perform a number of right circular rotations and return the values of the elements at
 * the given indices.
 */
public class CircularArrayRotation {

    /**
     *
     * @param a the array to rotate
     * @param k the rotation count
     * @param queries the indices to report
     * @return the values in the rotated {@code a} as requested in {@code queries}.
     */
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int length = a.size();
        int offset = k % length;
        List<Integer> newValues = new ArrayList<>();
        for (Integer q : queries) {
            int index = q - offset;
            if (index < 0) {
                index = length - offset + q;
            }
            newValues.add(a.get(index));
        }
        return newValues;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        List<Integer> a = Arrays.asList(1, 2, 3);
        int k = 9;
        List<Integer> q = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
//        List<Integer> q = Arrays.asList(0, 1, 2);
        List<Integer> shifted = circularArrayRotation(a, k, q);
        String newValues = shifted.stream().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(newValues);

    }
}
