package fifthstar;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModifiedKaprekarNumbersTest {

    @Test
    public void test_numberOfDigits_shouldReturnOne() {
        assertEquals(1, ModifiedKaprekarNumbers.findNumDigits(0));
    }

    @Test
    public void test_numberOfDigits_shouldReturnTwo() {
        assertEquals(2, ModifiedKaprekarNumbers.findNumDigits(10));
    }

    @Test
    public void test_numberOfDigits_shouldReturnThree() {
        assertEquals(3, ModifiedKaprekarNumbers.findNumDigits(101));
    }

    @Test
    public void test_isKaprekarNumber_shouldReturnTrue() {
        assertTrue(ModifiedKaprekarNumbers.isKaprekarNumber(9));
    }

    @Test
    public void test_isKaprekarNumber_shouldReturnFalse() {
        assertFalse(ModifiedKaprekarNumbers.isKaprekarNumber(5));
    }
}
