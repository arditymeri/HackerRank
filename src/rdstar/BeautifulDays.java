package rdstar;

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
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.reverse();
            String reversedValue = sb.toString();
            int reversed = Integer.parseInt(reversedValue);
            int r = Math.abs(day - reversed);
            System.out.println( "Day: " + day+ ",\t" + " reversed: " + reversed + ",\t difference:" + r);
            if (r % k == 0) {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int result = beautifulDays(13, 45, 3);
        System.out.println(result);
    }
}
