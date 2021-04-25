package rdstar;

/**
 * HackerLand Enterprise is adopting a new viral advertising strategy. When they launch a new product,
 * they advertise it to exactly 5 people on social media.
 * <p>
 * On the first day, half of those 5 people (i.e., floor(5/2)=2 ) like the advertisement and each shares it with  of their friends.
 * At the beginning of the second day, floor(5/2) * 3 = 6 people receive the advertisement.
 * <p>
 * Each day, floor(recipients/2) of the recipients like the advertisement and will share it with 3 friends on the following day.
 * Assuming nobody receives the advertisement twice, determine how many people have liked the ad by the end of a given
 * day, beginning with launch day as day 1.
 */
public class ViralAdvertising {

    public static int viralAdvertising(int n) {

        int cumulative = 2;
        int liked = 2;
        int shared;
        for (int i = 2; i <= n; i++) {
            shared = liked * 3;
            liked = shared / 2;
            cumulative += liked;
        }
        return cumulative;
    }

    public static void main(String[] args) {
        int result = viralAdvertising(5);
        System.out.println(result);

    }

}
