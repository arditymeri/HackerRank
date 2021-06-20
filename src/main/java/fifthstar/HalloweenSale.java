package fifthstar;

public class HalloweenSale {

    public static int howManyGames(int p, int d, int m, int s) {
        int sum = p;
        int games = 0;
        int price = p;
        while (sum <= s) {
            games++;
            price = Math.max(price - d, m);
            sum += price;

        }
        return games;
    }
}
