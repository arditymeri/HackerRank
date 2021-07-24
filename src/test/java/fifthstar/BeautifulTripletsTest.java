package fifthstar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BeautifulTripletsTest {

    @Test
    public void firstSample() {
        int c = BeautifulTriplets.beautifulTriplets(1, Arrays.asList(2, 2, 3, 4, 5));
        assertEquals(3, c);
    }

}