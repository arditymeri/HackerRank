package hard;

public class MorganAndString {

    public static String morganAndString(String a, String b) {
        int j = 0;
        int d = 0;
        StringBuilder sb = new StringBuilder();
        do {
            Character jack = a.charAt(j);
            Character daniel = b.charAt(d);
            int compare = jack.compareTo(daniel);
            if (compare < 0) {
                sb.append(jack);
                j++;
            } else if (compare > 0) {
                sb.append(daniel);
                d++;
            } else {
                int repeatedPrefixLength1 = findRepeatedPrefix(a.substring(j));
                int repeatedPrefixLength2 = findRepeatedPrefix(b.substring(d));
                int step = Math.min(repeatedPrefixLength1, repeatedPrefixLength2);
                String nextJ = a.substring(j + step);
                String nextD = b.substring(d + step);
                if(nextJ.isEmpty()) {
                    String aSuffix = a.substring(j);
                    if(aSuffix.compareTo(nextD) <= 0) {
                        sb.append(a, j, j + step);
                        j += step;
                    } else {
                        sb.append(b, d, d + step);
                        d += step;
                    }
                } else if (nextD.isEmpty()) {
                    String bSuffix = b.substring(j);
                    if(bSuffix.compareTo(nextD) > 0) {
                        sb.append(a, j, j + step);
                        j += step;
                    } else {
                        sb.append(b, d, d + step);
                        d += step;
                    }
                } else if (nextJ.compareTo(nextD) <= 0) {
                    sb.append(a, j, j + step);
                    j += step;
                } else {
                    sb.append(b, d, d + step);
                    d += step;
                }
            }

        } while (j != a.length() && d != b.length());
        if (j < a.length()) {
            String suffix = a.substring(j);
            sb.append(suffix);
        }
        if (d < b.length()) {
            String suffix = b.substring(d);
            sb.append(suffix);
        }
        return sb.toString();
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
