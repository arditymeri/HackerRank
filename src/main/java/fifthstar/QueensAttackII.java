package fifthstar;

import java.util.Arrays;
import java.util.List;

/**
 * You will be given a square chess board with one queen and a number of obstacles placed on it.
 * Determine how many squares the queen can attack.
 * <p>
 * A queen is standing on an nxn chessboard. The chess board's rows are numbered from 1 to n, going from bottom to top.
 * Its columns are numbered from 1 to n, going from left to right. Each square is referenced by a tuple, (r,c)
 * describing the row, r, and column, c, where the square is located.
 * <p>
 * The queen is standing at position (rq, cq). In a single move, she can attack any square in any of the eight
 * directions (left, right, up, down, and the four diagonals).
 */
public class QueensAttackII {
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int r1 = c_q - 1;
        int r2 = n - c_q;
        int c1 = r_q - 1;
        int c2 = n - r_q;
        int md1 = Math.min(r_q - 1, c_q - 1);
        int md2 = Math.min(n - r_q, n - c_q);
        int sd1 = Math.min(c_q - 1, n - r_q);
        int sd2 = Math.min(r_q - 1, n - c_q);
        for (List<Integer> obstacle : obstacles) {
            int i = obstacle.get(0);
            int j = obstacle.get(1);
            int key = inRow(r_q, c_q, i, j);
            if (key != 0) {
                if (key > 0) {
                    r2 = Math.min(r2, key - 1);
                } else {
                    r1 = Math.min(Math.abs(key) - 1, r1);
                }
            }
            int key2 = inCol(r_q, c_q, i, j);
            if (key2 != 0) {

                if (key2 > 0) {
                    c2 = Math.min(c2, key2 - 1);
                } else {
                    c1 = Math.min(Math.abs(key2) - 1, c1);
                }
            }

            int key3 = inMainDiag(r_q, c_q, i, j);
            if (key3 != 0) {
                if (key3 > 0) {
                    md2 = Math.min(md2, key3 - 1);
                } else {
                    md1 = Math.min(Math.abs(key3) - 1, md1);
                }
            }
            int key4 = inSecondDiag(r_q, c_q, i, j);
            if (key4 != 0) {
                if (key4 > 0) {
                    sd2 = Math.min(sd2, key4 - 1);
                } else {
                    sd1 = Math.min(sd1, Math.abs(key4) - 1);
                }
            }

        }
        return r1 + r2 + c1 + c2 + md1 + md2 + sd1 + sd2;
    }

    private static int inRow(int r_q, int c_q, int i, int j) {
        if (r_q != i) {
            return 0;
        }
        return j - c_q;
    }

    private static int inCol(int r_q, int c_q, int i, int j) {
        if (c_q != j) {
            return 0;
        }
        return i - r_q;
    }

    private static int inMainDiag(int r_q, int c_q, int i, int j) {
        if (c_q - r_q != j - i) {
            return 0;
        }
        return i - r_q;
    }

    private static int inSecondDiag(int r_q, int c_q, int i, int j) {
        if (r_q - i != -1 * (c_q - j)) {
            return 0;
        }
        return r_q - i;
    }

    public static void main(String[] args) {
        List<List<Integer>> obstacles = Arrays.asList(
                Arrays.asList(5, 5),
                Arrays.asList(4, 2),
                Arrays.asList(2, 3));

        int result = queensAttack(5, 10, 4, 3, obstacles);
        System.out.println(result);

    }
}
