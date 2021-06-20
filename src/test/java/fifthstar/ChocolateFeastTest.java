package fifthstar;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChocolateFeastTest {

    @Test
    public void chocolateFeast() {
        assertEquals(6, ChocolateFeast.chocolateFeast(10, 2, 5));
        assertEquals(3, ChocolateFeast.chocolateFeast(12, 4, 4));
        assertEquals(5, ChocolateFeast.chocolateFeast(6, 2, 2));
    }
}