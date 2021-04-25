package rdstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lily likes to play games with integers. She has created a new game where she determines the
 * difference between a number and its reverse. For instance, given the number 12, its reverse is 21.
 * Their difference is 9. The number 120 reversed is 21, and their difference is 99.
 *
 * She decides to apply her game to decision making. She will look at a numbered range of days
 * and will only go to a movie on a beautiful day.
 *
 * Given a range of numbered days, [i..j] and a number k, determine the number of days in the range
 * that are beautiful. Beautiful numbers are defined as numbers where |i - reverse(i)| is evenly
 * divisible by k. If a day's value is a beautiful number, it is a beautiful day. Return the number
 * of beautiful days in the range.
 */
public class BeautifulDays {

    public static int beautifulDays(int i, int j, int k) {
        int n = 0;
        for (int day = i; day <= j; day++) {
            String value = Integer.toString(day);
            List<Integer> digits = new ArrayList<>(value.chars().boxed().collect(Collectors.toList()));
            Collections.reverse(digits);
            String reversedValue = digits.stream()
                    .map(d -> Character.valueOf((char)d.intValue()).toString())
                    .collect(Collectors.joining());
            int reversed = Integer.parseInt(reversedValue);
            int r = Math.abs(i - reversed);
            if (r % k == 0) {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int result = beautifulDays(20, 23, 6);
        System.out.println(result);
    }
}
