package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaveHumanity {

    public static void virusIndices(String patientDNA, String virusDNA) {

        List<Integer> indices = new ArrayList<>();
        int pDNALength = patientDNA.length();
        int vDNALength = virusDNA.length();
        for (int i = 0; i <= pDNALength - vDNALength; i++) {
            if (patientDNA.startsWith(virusDNA, i)) {
                indices.add(i);
            } else {
                String dnaPart = patientDNA.substring(i, i+vDNALength);
                List<String> similarDNAs = generateSimilarDNAs(dnaPart, virusDNA);
                String dnaSuffix = patientDNA.substring(i);
                boolean match = similarDNAs.stream().anyMatch(dnaSuffix::startsWith);
                if(match) {
                    indices.add(i);
                }
            }
        }
        if(indices.isEmpty()) {
            System.out.println("No Match!");
        } else {
            String result = indices.stream()
                    .map(i -> i.toString())
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }

    private static List<String> generateSimilarDNAs(String dnaPart, String virusDNA) {
        List<String> similarDNAs = new ArrayList<>();
        int dnaLength = virusDNA.length();
        for (int i = 0; i < dnaLength; i++) {
            String similar;
            if (i == dnaLength - 1) {
                similar = virusDNA.substring(0, i) + dnaPart.charAt(i);
            } else {
                similar = virusDNA.substring(0, i) + dnaPart.charAt(i) + virusDNA.substring(i + 1, dnaLength);
            }
            similarDNAs.add(similar);
        }
        return similarDNAs;
    }

    public static void main(String[] args) {
        virusIndices("banana", "nan");
        virusIndices("atcgatcga", "cgg");

    }
}
