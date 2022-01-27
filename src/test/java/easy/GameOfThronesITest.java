package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfThronesITest {

    @ParameterizedTest
    @ValueSource(strings = {"aaabbbb", "cdcdcdcdeeeef"})
    void testPalindromes_shouldReturnYes(String value) {
        String result = GameOfThronesI.gameOfThrones(value);
        assertEquals("YES", result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaabbbbc", "cdcdcdcdeeeefa", "cdefghmnopqrstuvw"})
    void testPalindromes_shouldReturnNo(String value) {
        String result = GameOfThronesI.gameOfThrones(value);
        assertEquals("NO", result);
    }
}
