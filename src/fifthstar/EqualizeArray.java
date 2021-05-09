package fifthstar;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EqualizeArray {

    public static int equalizeArray(List<Integer> arr) {

        Map<Integer, Long> map = arr.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long mode = map.values()
                .stream()
                .max(Long::compareTo)
                .orElse(0L);
        return arr.size() - (int) mode;

    }

}
