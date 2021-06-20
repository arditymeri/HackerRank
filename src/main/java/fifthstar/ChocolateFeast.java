package fifthstar;

public class ChocolateFeast {

    public static int chocolateFeast(int n, int c, int m) {
        int firstRound = n/c;
        return firstRound + find(firstRound, 0, m);

    }

    private static int find(int wrappers, int remaining, int m) {
        if (wrappers + remaining < m) {
            return 0;
        }
        int n = (wrappers + remaining) / m;
        int r = (wrappers + remaining) % m;
        return n + find(n, r, m);
    }
}
