package fifthstar;

import java.util.Arrays;
import java.util.List;

public class OrganizingContainersOfBalls {

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        for (int i = 0; i < n; i++) {
            boolean swapped = swapAll(i, container);
            if (!swapped) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    private static boolean swapAll(int j, List<List<Integer>> containers) {
        List<Integer> balls = containers.get(j);
        long sum = balls.stream().mapToLong(Integer::longValue).sum();
        long c = (long) balls.get(j);

        if (sum == c) {
            return true;
        }
        long r = sum - c;
        long s = 0;
        for (int i = 0; i < containers.size(); i++) {
            if (i != j) {
                List<Integer> container = containers.get(i);
                s += container.get(j);
            }
        }
        return s == r;
    }

    public static void main(String[] args) {
        /*
         *   999336263 998799923
         *   998799923 999763019
         */

        String result;
        List<List<Integer>> containers1 = Arrays.asList(
                Arrays.asList(999336263, 998799923),
                Arrays.asList(998799923, 999763019)
        );
        result = organizingContainers(containers1);
        System.out.println(result);

        /*
        997612619   934920795   998879231   999926463
        960369681   997828120   999792735   979622676
        999013654   998634077   997988323   958769423
        997409523   999301350   940952923   993020546
         */
        List<List<Integer>> containers2 = Arrays.asList(
                Arrays.asList(997612619, 934920795, 998879231, 999926463),
                Arrays.asList(960369681, 997828120, 999792735, 979622676),
                Arrays.asList(999013654, 998634077, 997988323, 958769423),
                Arrays.asList(997409523, 999301350, 940952923, 993020546)
        );
        result = organizingContainers(containers2);
        System.out.println(result);

        List<List<Integer>> containers22 = Arrays.asList(
                Arrays.asList(1, 1, 4, 1),
                Arrays.asList(0, 0, 0, 2),
                Arrays.asList(2, 1, 0, 1),
                Arrays.asList(0, 0, 0, 3)
        );
        result = organizingContainers(containers2);
        System.out.println(result);


    }
}
