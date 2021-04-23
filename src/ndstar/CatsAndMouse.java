package ndstar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Two cats and a mouse are at various positions on a line. You will be given their starting positions. Your task is
 * to determine which cat will reach the mouse first, assuming the mouse does not move and the cats travel at equal
 * speed. If the cats arrive at the same time, the mouse will be allowed to move and it will escape while they fight.
 * <p>
 * You are given q queries in the form of x, y, and z representing the respective positions for cats A and B, and for
 * mouse C. Complete the function catAndMouse to return the appropriate answer to each query, which will be printed on a
 * new line.
 * <p>
 * If cat A catches the mouse first, print Cat A.
 * If cat B catches the mouse first, print Cat B.
 * If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.
 */
public class CatsAndMouse {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {

        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        if (a == b) {
            return "Mouse C";
        } else if (a < b) {
            return "Cat A";
        } else {
            return "Cat B";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
