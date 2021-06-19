package fourthstar;

public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c, int k) {

        int n = c.length;
        int position = 0;
        int cost = 0;

        while (true) {
            cost++;
            if (c[position] == 1) {
                cost += 2;
            }
            position = (position + k) % n;
            if (position == 0) {
                break;
            }
        }
        return 100 - cost;
    }

    public static void main(String[] args) {
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;
        int result = jumpingOnClouds(c, k);
        System.out.println(result);

    }
}
