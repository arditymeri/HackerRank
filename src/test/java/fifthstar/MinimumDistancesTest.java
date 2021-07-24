package fifthstar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDistancesTest {

    @Test
    public void minimumDistances() {
        int d1 = MinimumDistances.minimumDistances(Arrays.asList(3, 2, 1, 2, 3));
        assertEquals(2, d1);
        int d2 = MinimumDistances.minimumDistances(Arrays.asList(7, 1, 3, 4, 1, 7));
        assertEquals(3, d2);
    }
}