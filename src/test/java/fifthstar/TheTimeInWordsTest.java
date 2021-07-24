package fifthstar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheTimeInWordsTest {

    @Test
    void timeInWords() {
        String time = TheTimeInWords.timeInWords(5, 47);
        assertEquals("thirteen minutes to six", time);
    }
}