package fourthstar;

/**
 * You have two strings of lowercase English letters. You can perform two types of operations on the first string:
 * <p>
 * 1. Append a lowercase English letter to the end of the string.
 * 2. Delete the last character of the string. Performing this operation on an empty string results in an empty string.
 * Given an integer, k, and two strings, s and t, determine whether or not you can convert s to t by performing
 * exactly k of the above operations on s. If it's possible, print Yes. Otherwise, print No.
 */
public class AppendAndDelete {

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int sLen = s.length();
        int tLen = t.length();
        int diffLen = Math.abs(sLen - tLen);
        if (sLen == tLen) {
            return compareSameLength(s, t, k);
        } else if (sLen > tLen) {
            String prefixS = s.substring(0, tLen);
            return compareSameLength(prefixS, t, k - diffLen);
        } else {
            String prefixT = t.substring(0, sLen);
            return compareSameLength(s, prefixT, k - diffLen);
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
        String sPrefix = s.substring(0, lLen - halfK);
        String tPrefix = t.substring(0, lLen - halfK);
        if (sPrefix.equals(tPrefix)) {
            return yes;
        } else {
            return no;
        }
    }

    public static void main(String[] args) {


        String result = appendAndDelete("bbbbb", "babbb", 8);
        System.out.println(result);
    }
}
