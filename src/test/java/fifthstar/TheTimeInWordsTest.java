package fifthstar;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheTimeInWordsTest {

    @Test
    public void timeInWords() {
        String time = TheTimeInWords.timeInWords(5, 47);
        assertEquals("thirteen minutes to six", time);
    }
}