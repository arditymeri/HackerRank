package hard;

import java.util.ArrayList;
import java.util.List;

public class SaveHumanity {

    public static void virusIndices(String patientDNA, String virusDNA) {

        int pDNALength = patientDNA.length();
        int vDNALength = virusDNA.length();
        boolean matchFound = false;
        for (int i = 0; i <= pDNALength - vDNALength; i++) {
            String dnaPart = patientDNA.substring(i, i + vDNALength);
            if (matchesSimilarDNA(dnaPart, virusDNA)) {
                System.out.print(i + " ");
                matchFound = true;
            }
        }
        if (matchFound) {
            System.out.println();
        } else {
            System.out.println("No Match!");
        }
    }

    public static List<Integer> calcVirusIndices(String patientDNA, String virusDNA) {
        List<Integer> indices = new ArrayList<>();
        int pDNALength = patientDNA.length();
        int vDNALength = virusDNA.length();
        for (int i = 0; i <= pDNALength - vDNALength; i++) {
            String dnaPart = patientDNA.substring(i, i + vDNALength);
            if (matchesSimilarDNA(dnaPart, virusDNA)) {
                indices.add(i);
            }
        }
        return indices;
    }

    private static boolean matchesSimilarDNA(String dnaPart, String virusDNA) {
        int dnaLength = virusDNA.length();
        int differencesCount = 0;
        for (int i = 0; i < dnaLength; i++) {
            Character p = dnaPart.charAt(i);
            Character v = virusDNA.charAt(i);
            if (!p.equals(v)) {
                differencesCount++;
            }
            if (differencesCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        virusIndices("banana", "nan");
        virusIndices("atcgatcga", "cgg");

    }
}
