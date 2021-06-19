package fifthstar;

/**
 * Taum is planning to celebrate the birthday of his friend, Diksha.
 * There are two types of gifts that Diksha wants from Taum: one is black and the other is white.
 * To make her happy, Taum has to buy b black gifts and w white gifts.
 *
 * The cost of each black gift is bc units.
 * The cost of every white gift is wc units.
 * The cost to convert a black gift into white gift or vice versa is z units.
 * Determine the minimum cost of Diksha's gifts.
 */
public class TaumAndBDay {

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        if(bc > wc + z) {
            return (long)w * wc + (long)b * wc + (long)z * b;
        } else if (wc > bc + z) {
            return (long)bc * b + (long)w * bc + (long)z * w;
        }
        return (long)b * bc + (long)w * wc;
    }

    public static void main(String[] args) {

    }
}
