package fifthstar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class ModifiedKaprekarNumbersTest {

    @Test
    void test_numberOfDigits_shouldReturnOne() {
        assertEquals(1, ModifiedKaprekarNumbers.findNumDigits(0));
    }

    @Test
    void test_numberOfDigits_shouldReturnTwo() {
        assertEquals(2, ModifiedKaprekarNumbers.findNumDigits(10));
    }

    @Test
    void test_numberOfDigits_shouldReturnThree() {
        assertEquals(3, ModifiedKaprekarNumbers.findNumDigits(101));
    }

    @Test
    void test_isKaprekarNumber_shouldReturnTrue() {
        assertTrue(ModifiedKaprekarNumbers.isKaprekarNumber(9));
    }

    @Test
    void test_isKaprekarNumber_shouldReturnFalse() {
        assertFalse(ModifiedKaprekarNumbers.isKaprekarNumber(5));
    }

    @Test
    void test_isKaprekarNumber45_shouldReturnTrue() {
        assertTrue(ModifiedKaprekarNumbers.isKaprekarNumber(45));

    }

    @Test
    public void test_printNumbers() {
        ModifiedKaprekarNumbers.kaprekarNumbers(1, 98);
        ModifiedKaprekarNumbers.kaprekarNumbers(9, 20);
        assertTrue(true);
    }
}
