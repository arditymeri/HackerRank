package hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveHumanityTest {

    private static Stream<Arguments> input09() throws IOException {
        Path inputPath = Path.of("src", "test", "resources", "SaveHumanity_input09.txt");
        Path outputPath = Path.of("src", "test", "resources", "SaveHumanity_output09.txt");
        List<String> inputLines = Files.readAllLines(inputPath).stream().skip(1)
                .map(value -> value.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        List<String> outputLines = Files.readAllLines(outputPath);
        return Stream.iterate(0, i -> i + 1)
                .limit(outputLines.size())
                .map(i -> Arguments.of(
                        inputLines.get(2 * i),
                        inputLines.get(2 * i  + 1),
                        outputLines.get(i)));
    }

    @ParameterizedTest
    @MethodSource(value = "input09")
    void test09(String dna, String vDna, String output) {
        List<Integer> result = SaveHumanity.calcVirusIndices(dna, vDna);
        String actual = result.isEmpty() ? "No Match!" : result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        assertEquals(output, actual);
    }

}
