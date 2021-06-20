package fifthstar;

import java.util.HashMap;
import java.util.Map;

public class TheTimeInWords {

    private static Map<Integer, String> initMap() {
        HashMap<Integer, String>map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(21, "twenty one");
        map.put(22, "twenty two");
        map.put(23, "twenty three");
        map.put(24, "twenty four");
        map.put(25, "twenty five");
        map.put(26, "twenty six");
        map.put(27, "twenty seven");
        map.put(28, "twenty eight");
        map.put(29, "twenty nine");
        map.put(30, "thirty");
        return map;
    }

    public static String timeInWords(int h, int m) {
        Map<Integer, String> keyMap = initMap();
        if (m == 0) {
            return keyMap.get(h) + " o' clock";
        } else if(m == 1) {
            return keyMap.get(m) + " minute past " + keyMap.get(h);
        } else if(m == 15) {
            return "quarter past " + keyMap.get(h);
        } else if (m == 30) {
            return "half past " + keyMap.get(h);
        } else if (m < 30) {
            return keyMap.get(m) + " minutes past " + keyMap.get(h);
        } else if (m == 59) {
            int hours = h + 1 == 13 ? 1 : h + 1;
            return keyMap.get(m) + " minute to " + keyMap.get(hours);
        } else if(m == 45) {
            int hours = h + 1 == 13 ? 1 : h + 1;
            return "quarter to " + keyMap.get(hours);
        } else {
            int hours = h + 1 == 13 ? 1 : h + 1;
            return keyMap.get(60 - m) + " minutes to " + keyMap.get(hours);
        }
    }
}
