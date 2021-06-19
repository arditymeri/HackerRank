package fifthstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizingContainersOfBalls {

    public static String organizingContainers(List<List<Integer>> container) {
        List<Integer> containerSizes = container
                .stream()
                .map(c -> c.stream().mapToInt(Integer::intValue).sum())
                .collect(Collectors.toList());
        List<Integer> colors = sumColons(container);
        for (Integer containerSize : containerSizes) {
            boolean removed = colors.remove(containerSize);
            if (!removed) {
                return "Impossible";
            }
        }
        return colors.isEmpty() ? "Possible" : "Impossible";
    }

    private static List<Integer> sumColons(List<List<Integer>> containers) {
        List<Integer> colors = new ArrayList<>();
        int m = containers.get(0).size();
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (List<Integer> container : containers) {
                sum += container.get(j);
            }
            colors.add(sum);
        }
        return colors;
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
        result = organizingContainers(containers22);
        System.out.println(result);


    }
}
