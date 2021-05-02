package fourthstar;

import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * #Medium
 */
public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        while (true) {
            int index = findMaxCol(s, k);
            if (index < 0) {
                break;
            }
            s.remove(index);
        }
        return s.size();
    }

    private static int findMaxCol(List<Integer> s, int k) {
        int index = -1;
        int max = 0;
        for (int i = 0; i < s.size(); i++) {
            int c = 0;
            int n = s.get(i);
            for (int j = 0; j < s.size(); j++) {
                if (i != j) {
                    int m = s.get(j);
                    if((m+n)%k == 0) {
                        c++;
                    }
                }
            }
            if (c > max) {
                index = i;
                max = c;
            }
        }
        return index;
    }

    /**
     * Cross matrix solution
     */

    public static int nonDivisibleSubset2(int k, List<Integer> s) {
        int removed = 0;
        int n = s.size();
        short[][] cross = calcCrossMatrix(k, s);
        while (hasOnes(cross, n)) {
            int index = findMaxCol(cross, n);
            for (int i = 0; i < n; i++) {
                cross[i][index] = 0;
                cross[index][i] = 0;
            }
            removed++;
        }
        return n - removed;
    }

    private static int findMaxCol(short[][] cross, int n) {
        int index = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += cross[i][j];
            }
            if (sum > maxSum) {
                index = i;
                maxSum = sum;
            }
        }
        return index;
    }

    private static boolean hasOnes(short[][] cross, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cross[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static short[][] calcCrossMatrix(int k, List<Integer> s) {
        int size = s.size();
        short[][] crossMatrix = new short[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean divisible = false;
                if (i != j) {
                    divisible = (s.get(i) + s.get(j)) % k == 0;
                }
                crossMatrix[i][j] = divisible ? (short) 1 : (short)0;
            }
        }
        return crossMatrix;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
//        int max = nonDivisibleSubset(3, Arrays.asList(1, 7, 2, 4));
        int max = nonDivisibleSubset(7, new ArrayList<>(Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)));
        System.out.println(max);
        Duration duration = Duration.ofNanos(System.nanoTime() - start);
        System.out.println("Duration:" + duration.toSeconds());

    }

    public static int findNextMaxSubset(int k, List<Integer> subset, List<Integer> set) {
        int maxSize = subset.size();
        for (Integer i : set) {
            boolean nonDivisible = true;
            for (Integer j : subset) {
                if ((i + j) % k == 0) {
                    nonDivisible = false;
                    break;
                }
            }
            if (nonDivisible) {
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
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input09.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("NonDivisibleResult.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = NonDivisibleSubset.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

