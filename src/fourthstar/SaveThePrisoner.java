package fourthstar;

/**
 * A jail has a number of prisoners and a number of treats to pass out to them. Their jailer decides the fairest way to
 * divide the treats is to seat the prisoners around a circular table in sequentially numbered chairs. A chair number
 * will be drawn from a hat. Beginning with the prisoner in that chair, one candy will be handed to each prisoner
 * sequentially around the table until all have been distributed.
 * <p>
 * The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes awful.
 * Determine the chair number occupied by the prisoner who will receive that candy.
 */
public class SaveThePrisoner {

    /**
     * @param n the number of prisoners
     * @param m the number of sweets
     * @param s the chair number to begin passing out sweets from
     * @return the chair number of the prisoner to warn
     */
    public static int saveThePrisoner(int n, int m, int s) {
        int withOffset = m + s - 1;
        int remainder = withOffset % n;
        int lastSeat = remainder == 0 ? n : remainder;
        return lastSeat;
    }

    public static void main(String[] args) {
        printResult(5, 2, 1);
        printResult(5, 2, 2);
        printResult(7, 19, 2);
        printResult(3, 7, 3);
    }

    private static void printResult(int i, int i1, int i2) {
        int result = saveThePrisoner(i, i1, i2);
        System.out.println(result);
    }
}
