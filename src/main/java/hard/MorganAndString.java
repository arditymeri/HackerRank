package hard;

public class MorganAndString {

    public static String morganAndString(String aa, String bb) {
        int j = 0;
        int d = 0;
        String jackLetters = aa + "z";
        String danielLetters = bb + "z";
        StringBuilder sb = new StringBuilder();
        do {
            Character jack = jackLetters.charAt(j);
            Character daniel = danielLetters.charAt(d);
            int compare = jack.compareTo(daniel);
            if (compare < 0) {
                sb.append(jack);
                j++;
            } else if (compare > 0) {
                sb.append(daniel);
                d++;
            } else {
                int repeatedPrefixLength1 = findRepeatedPrefix(jackLetters.substring(j));
                int repeatedPrefixLength2 = findRepeatedPrefix(danielLetters.substring(d));
                int step = Math.min(repeatedPrefixLength1, repeatedPrefixLength2);
                String nextJ = jackLetters.substring(j + step);
                String nextD = danielLetters.substring(d + step);
                if(nextJ.isEmpty()) {
                    sb.append(danielLetters, d, d + repeatedPrefixLength2);
                    d += repeatedPrefixLength2;
                } else if (nextD.isEmpty()) {
                    sb.append(jackLetters, j, j + repeatedPrefixLength1);
                    j += repeatedPrefixLength1;
                } else if ((nextJ).compareTo(nextD) <= 0) {
                    sb.append(jackLetters, j, j + step);
                    j += step;
                } else {
                    sb.append(danielLetters, d, d + step);
                    d += step;
                }
            }

        } while (j != jackLetters.length() && d != danielLetters.length());
        if (j < jackLetters.length()) {
            String suffix = jackLetters.substring(j);
            sb.append(suffix);
        }
        if (d < danielLetters.length()) {
            String suffix = danielLetters.substring(d);
            sb.append(suffix);
        }
        String result = sb.toString();
        return result.substring(0, result.length()-2);
    }

    private static int findRepeatedPrefix(String substring) {
        Character c = substring.charAt(0);
        int i = 1;
        while (i < substring.length()) {
            Character c2 = substring.charAt(i);
            if (c2.equals(c)) {
                i++;
            } else break;
            ;
        }
        return i;
    }
}
