package fourthstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * #Medium
 */
public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int maxSize = 0;
        for (Integer i : s) {
            List<Integer> newSet = new ArrayList<>(s);
            newSet.remove(i);
            List<Integer> subset = Collections.singletonList(i);
            int size = findNextMaxSubset(k, subset, newSet);
            if (size > maxSize) {
                maxSize = size;
            }
        }

        return maxSize;
    }

    public static int findNextMaxSubset(int k, List<Integer>subset, List<Integer> set) {
        int maxSize = subset.size();
        for (Integer i : set) {
            boolean nonDivisible = true;
            for (Integer j : subset) {
                if ((i + j) % k == 0) {
                    nonDivisible = false;
                    break;
                }
            }
            if(nonDivisible) {
                maxSize = subset.size() + 1;
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(i);
                List<Integer> newSet = new ArrayList<>(set);
                newSet.remove(i);
                int newMax = findNextMaxSubset(k, newSubset, newSet);
                if (newMax > maxSize) {
                    maxSize = newMax;
                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
//        int max = nonDivisibleSubset(3, Arrays.asList(1, 7, 2, 4));
        long start = System.nanoTime();
        int max = nonDivisibleSubset(7, Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436));
        System.out.println(max);
        System.out.println("Duration:" + (System.nanoTime() - start));

    }
}
