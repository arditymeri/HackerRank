package ndstar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int cost = 72;
        for (int i = 1; i < 9; i++) {
            int[][] current = new int[3][3];
            current[0][0] = i;
            int newCost = findCost(current, 0, cost, s);
            if (newCost < cost) {
                cost = newCost;
            }
        }
        return cost;
    }

    private static int findCost(int[][] current, int index, int cost, int[][] s) {
        if (index == 9) {
            if (!isMagic(current)) {
                return cost;
            }
            int newCost = calcCost(current, s);
            return Math.min(newCost, cost);
        }
        int minCost = cost;
        for (int i = 1; i <= 9; i++) {
            if (!containsKey(current, index + 1, i)) {
                current[index / 3][index % 3] = i;
                int currentCost = findCost(current, index + 1, minCost, s);
                if (currentCost < minCost) {
                    minCost = currentCost;
                }
            }
        }
        return minCost;
    }

    private static boolean containsKey(int[][] current, int index, int key) {
        for (int i = 0; i < index; i++) {
            if (current[i / 3][i % 3] == key) {
                return true;
            }
        }
        return false;
    }

    private static int calcCost(int[][] temp, int[][] s) {
        int cost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cost += Math.abs(temp[i][j] - s[i][j]);
            }
        }
        return cost;
    }

    private static boolean isMagic(int[][] temp) {
        int firstRow = Arrays.stream(temp[0]).sum();
        int secondRow = Arrays.stream(temp[1]).sum();
        if (firstRow != secondRow) {
            return false;
        }
        int thirdRow = Arrays.stream(temp[2]).sum();
        if (thirdRow != secondRow) {
            return false;
        }

        int firstCol = 0;
        int secondCol = 0;
        int thirdCol = 0;
        int firstDiag = 0;
        int secondDiag = 0;
        for (int i = 0; i < 3; i++) {
            firstDiag += temp[i][i];
            secondDiag += temp[i][2 - i];
            firstCol += temp[i][0];
            secondCol += temp[i][1];
            thirdCol += temp[i][2];
        }

        return firstCol == firstRow && firstCol == secondCol && firstCol == thirdCol
                && firstCol == firstDiag
                && firstCol == secondDiag;

    }

    private static void printMagicSquare(int[][] current) {
        String matrix = Arrays.stream(current)
                .map(row ->
                        Arrays.stream(row)
                                .boxed()
                                .map(Object::toString)
                                .collect(Collectors.joining(",")))
                .collect(Collectors.joining("\n"));
        System.out.println("Magic Square");
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][] s ={{4, 9, 2}, {3, 5, 7}, {8, 1, 5}};
        int result = formingMagicSquare(s);
        System.out.println("Result: " + result);

    }
}
