package medium;

import java.util.*;
import java.util.stream.Collectors;

public class BomberMan {
    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {

        Cell[][] cells = initCells(grid);
        printGrid(cells);
        int seconds = 2;
        boolean fill = true;
        while (seconds <= n) {
            if(fill) {
                for (Cell[] row : cells) {
                    for (Cell cell : row) {
                        cell.fill();
                        cell.tick();
                    }
                }
                fill = false;
            } else {
                List<Cell> blasts = new ArrayList<>();
                for (Cell[] row : cells) {
                    for (Cell cell : row) {
                        if (cell.watch()) {
                            blasts.add(cell);
                        }
                        cell.tick();
                    }
                }
                for(Cell cell : blasts) {
                    updateBlast(cells, cell.i, cell.j);
                }
                fill = true;
            }
            printGrid(cells);
            seconds++;
        }
        List<String> result = new ArrayList<>();
        for (Cell[] row : cells) {
            String rowValue = Arrays.stream(row)
                    .map(cell -> cell.bomb?"O":".")
                    .collect(Collectors.joining(""));
            result.add(rowValue);
        }
        return result;
    }

    private static void printGrid(Cell[][]cells) {
        List<String> result = new ArrayList<>();
        for (Cell[] row : cells) {
            String rowValue = Arrays.stream(row)
                    .map(cell -> cell.bomb?"O":".")
                    .collect(Collectors.joining(""));
            result.add(rowValue);
        }
        String value = String.join("\n", result);
        System.out.println(value);
        System.out.println();
    }

    private static void updateBlast(Cell[][] cells, int i, int j) {
        int rows = cells.length;
        int columns = cells[0].length;
        int iMinus = Math.max(0, i-1);
        int iPlus = Math.min(rows-1, i+1);
        int jMinus = Math.max(0, j - 1);
        int jPlus = Math.min(columns-1, j+1);
        cells[iMinus][j].reset();
        cells[i][jPlus].reset();
        cells[iPlus][j].reset();
        cells[i][jMinus].reset();
    }

    private static Cell[][] initCells(List<String> grid) {
        Cell[][] cells = new Cell[grid.size()][grid.get(0).length()];
        int i = 0;
        for (String row : grid) {
            for (int j = 0; j < row.length(); j++) {
                char cell = row.charAt(j);
                if('0' == cell) {
                    cells[i][j] = new Cell(i, j,true, 1);
                    cells[i][j].tick();
                } else {
                    cells[i][j] = new Cell(i, j, false, 0);
                }
            }
            i++;
        }
        return cells;
    }

    static class Cell {
        int i;
        int j;
        boolean bomb;
        int timer;

        public Cell(int i, int j, boolean bomb, int timer) {
            this.i = i;
            this.j = j;
            this.bomb = bomb;
            this.timer = timer;
        }

        void fill() {
            if(!bomb) {
                bomb = true;
                timer = 0;
            }

        }

        void tick() {
            if(bomb) {
                timer++;
            }
        }

        boolean watch() {
            if(!bomb) {
                return false;
            }
            if(timer == 3) {
                reset();
                return true;
            }
            return false;
        }

        void reset() {
            timer = 0;
            bomb = false;
        }
    }

    public static void main(String[] args) {
        List<String> grid = Arrays.asList(
                ".......",
                "...0...",
                "....0..",
                ".......",
                "00.....",
                "00.....");
        List<String> result = BomberMan.bomberMan(3, grid);


    }
}
