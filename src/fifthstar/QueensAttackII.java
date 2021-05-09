package fifthstar;

import java.util.Arrays;
import java.util.List;

public class QueensAttackII {
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int attacked = 0;
        for (int i = c_q + 1; i <= n; i++) {
            if (isObstacle(obstacles, r_q, i)) {
                break;
            }
            attacked++;
        }

        for (int i = c_q - 1; i >= 1; i--) {
            if (isObstacle(obstacles, r_q, i)) {
                break;
            }
            attacked++;
        }

        for (int i = r_q + 1; i <= n; i++) {
            if (isObstacle(obstacles, i, c_q)) {
                break;
            }
            attacked++;
        }
        for (int i = r_q - 1; i >= 1; i--) {
            if (isObstacle(obstacles, i, c_q)) {
                break;
            }
            attacked++;
        }

        for (int i = r_q + 1, j = c_q + 1; i <= n && j <= n; i++, j++) {
            if (isObstacle(obstacles, i, j)) {
                break;
            }
            attacked++;
        }

        for (int i = r_q - 1, j = c_q - 1; i >= 1 && j >= 1; i--, j--) {
            if (isObstacle(obstacles, i, j)) {
                break;
            }
            attacked++;
        }

        for (int i = r_q + 1, j = c_q - 1; i <= n && j >= 1; i++, j--) {
            if (isObstacle(obstacles, i, j)) {
                break;
            }
            attacked++;
        }

        for (int i = r_q - 1, j = c_q + 1; i >= 1 && j <= n; i--, j++) {
            if (isObstacle(obstacles, i, j)) {
                break;
            }
            attacked++;
        }


        return attacked;
    }

    private static boolean isObstacle(List<List<Integer>> obstacles, int r, int c) {

        for (List<Integer> integers : obstacles) {
            if (integers.get(0) == r && integers.get(1) == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        5 3
        4 3
        5 5
        4 2
        2 3
         */
        List<List<Integer>> obstacles = Arrays.asList(Arrays.asList(5, 5), Arrays.asList(4, 2), Arrays.asList(2, 3));
        int result = queensAttack(5, 3, 4, 3, obstacles);
        System.out.println(result);

    }
}
