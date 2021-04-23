package ndstar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int [][] temp = {{0,0,0},{0,0,0},{0,0,0}};
        int cost = 81;
        for (int i = 111111111; i <= 999999999; i++) {
            int key = i;

            temp[0][0] = key % 10;
            key /= 10;

            temp[0][1] = key % 10;
            key /= 10;

            temp[0][2] = key % 10;
            key /= 10;

            temp[1][0] = key % 10;
            key /= 10;

            temp[1][1] = key % 10;
            key /= 10;

            temp[1][2] = key % 10;
            key /= 10;

            temp[2][0] = key % 10;
            key /= 10;

            temp[2][1] = key % 10;
            key /= 10;

            temp[2][2] = key % 10;

            if(!hasZeros(temp)
                    //&& isMagic(temp)
            ) {
                int currentCost = findCost(temp, s);
                if(currentCost < cost) {
                    cost = currentCost;
                }
            }
        }
        return cost;
    }

    private static int findCost(int[][] temp, int[][] s) {
        int cost = 0;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cost += Math.abs(temp[i][j] - s[i][j]);
            }
        }
        return cost;
    }

    private static boolean isMagic(int[][] temp) {
        int firstRow = Arrays.stream(temp[0]).sum();
        int secondRow = Arrays.stream(temp[1]).sum();
        if(firstRow != secondRow) {
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

    private static boolean hasZeros(int[][] temp) {
        return Arrays.stream(temp)
                .flatMapToInt(Arrays::stream)
                .anyMatch(i -> i == 0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] s =
                {{4, 8, 2},
                {4, 5, 7},
                {6, 1, 6}};
        int result = formingMagicSquare(s);
        System.out.println("Result: " + result);

    }
}
