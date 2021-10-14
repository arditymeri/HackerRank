package fifthstar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceLaneTest {

    @Test
    void test1() {
        List<Integer> widths = asList(1, 2, 2, 2, 1);
        List<List<Integer>> cases = asList(asList(2, 3), asList(1, 4), asList(2,4), asList(2, 4), asList(2, 3));

        List<Integer> result = ServiceLane.serviceLane(5, widths, cases);
        List<Integer> expected = Arrays.asList(2, 1, 1, 1, 2);
        assertEquals(expected, result);
    }
}
