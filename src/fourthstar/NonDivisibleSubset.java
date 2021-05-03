package fourthstar;

import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * #Medium
 */
public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int originalN = s.size();
        List<Integer> moduloK = s.stream()
                .map(i -> i % k)
                .collect(Collectors.toList());
        Map<Integer, Long> distinctModuloK = moduloK.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (int i = 0; i < k; i++) {
            if(!distinctModuloK.containsKey(i)) {
                distinctModuloK.put(i, 0L);
            }
        }
        int toRemove = (int) Math.max(0,  distinctModuloK.get(0) - 1);
        for (int i = 1; i <= (k-1)/2; i++) {
            toRemove += Math.min(distinctModuloK.get(i), distinctModuloK.get(k-i));
        }
        if (k % 2 == 0) {
            toRemove += (int) Math.max(0,  distinctModuloK.get(k/2) - 1);
        }
        return originalN - toRemove;
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
//        int max = nonDivisibleSubset(3, Arrays.asList(1, 7, 2, 4));
        int max = nonDivisibleSubset(7, new ArrayList<>(Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)));
        System.out.println(max);
        Duration duration = Duration.ofNanos(System.nanoTime() - start);
        System.out.println("Duration:" + duration.toSeconds());

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

