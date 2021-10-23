package hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorganAndStringTest {

    private static Stream<Arguments> input05() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "MorganAndString_input05.txt");
        Path outputPath = Path.of("src", "test", "resources", "MorganAndString_output05.txt");
        List<String> inputLines = Files.readAllLines(inputPath);
        List<String> outputLines = Files.readAllLines(outputPath);
        return Stream.iterate(0, i -> i + 1)
                .map(i -> Arguments.of(
                        inputLines.get(2 * i + 1),
                        inputLines.get(2 * i + 2),
                        outputLines.get(i)))
                .limit(5);
    }

    private static Stream<Arguments> input16() throws Exception {
        Path inputPath = Path.of("src", "test", "resources", "MorganAndString_input16.txt");
        Path outputPath = Path.of("src", "test", "resources", "MorganAndString_output16.txt");
        List<String> inputLines = Files.readAllLines(inputPath);
        List<String> outputLines = Files.readAllLines(outputPath);
        return Stream.iterate(0, i -> i + 1)
                .map(i -> Arguments.of(
                        inputLines.get(2 * i + 1),
                        inputLines.get(2 * i + 2),
                        outputLines.get(i)))
                .limit(5);
    }

    private static Stream<Arguments> customTests() {
        return Stream.of(
                Arguments.of("JACK", "DANIEL", "DAJACKNIEL"),
                Arguments.of("ABACABA", "ABACABA", "AABABACABACABA"),
                Arguments.of("AAAZ", "AACDE", "AAAAACDEZ"),
                Arguments.of("ZZZAA", "ZZBC", "ZZBCZZZAA"),
                Arguments.of("ZZZ", "ZZZA", "ZZZAZZZ"),
                Arguments.of("ZZZAZ", "ZZZAB", "ZZZABZZZAZ"),
                Arguments.of("AZZAAZ", "ZZAZZA", "AZZAAZZAZZAZ"),
                Arguments.of("ZZZA", "ZZZ", "ZZZAZZZ")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "customTests")
    void customTests(String jack, String daniel, String expected) {
        String actual = MorganAndString.morganAndString(jack, daniel);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "input05")
    void test05(String input1, String input2, String expected) {
        String actual = MorganAndString.morganAndString(input1, input2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource(value = "input16")
    void test16(String input1, String input2, String expected) {
        String actual = MorganAndString.morganAndString(input1, input2);
        assertEquals(expected, actual);
    }
}
