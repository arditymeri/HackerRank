package fourthstar;

public class AppendAndDelete {

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int lLen = s.length();
        int tLen = t.length();

        if (lLen == tLen) {
            return compareSameLength(s, t, k);
        } else if (lLen > tLen) {
            int diffLen = lLen - tLen;
            String prefixS = s.substring(0, diffLen);
            return compareSameLength(prefixS, t, k - diffLen);

        } else {
            int diffLen = tLen - lLen;
            String prefixS = t.substring(0, diffLen);
            return compareSameLength(prefixS, t, k - diffLen);
        }
    }

    private static String compareSameLength(String s, String t, int k) {
        final String yes = "Yes";
        final String no = "No";
        if (k < 0) {
            return no;
        }
        int lLen = s.length();
        if (k / 2 >= lLen) {
            return yes;
        }
        if (k % 2 != 0) {
            return no;
        }
        int halfK = k / 2;
        String sPrefix = s.substring(0, halfK);
        String tPrefix = t.substring(0, halfK);
        if (sPrefix.equals(tPrefix)) {
            return yes;
        } else {
            return no;
        }
    }

    public static void main(String[] args) {
//        String result = appendAndDelete("hackerhappy", "hackerrank", 9);
//        String result = appendAndDelete("aba", "aba", 7);
        String result = appendAndDelete("ashley", "ash", 2);
        System.out.println(result);
    }
}
