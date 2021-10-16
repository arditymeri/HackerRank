package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class MatrixLayerRotation {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numLayers = Math.min(m, n) / 2;

        List<List<Integer>> layers = new ArrayList<>();
        for (int i = 0; i < numLayers; i++) {
            layers.add(findLayer(matrix, i));
        }
        for (List<Integer> layer : layers) {
            shift(layer, r);
        }
        fill(layers, matrix);
        matrix.forEach(list -> {
            String line = list.stream().map(i -> i.toString()).collect(Collectors.joining(" "));
            System.out.println(line);
        });
    }

    private static void fill(List<List<Integer>> layers, List<List<Integer>> matrix) {
        for (int i = 0; i < layers.size(); i++) {
            List<Integer> layer = layers.get(i);
            fill(layer, i, matrix);
        }
    }

    private static void fill(List<Integer> layer, int index, List<List<Integer>> matrix) {
        int i = index;
        int j = index;
        int m = matrix.size();
        int n = matrix.get(0).size();
        for (Integer element : layer) {
            matrix.get(i).set(j, element);
            Point point = findNextPosition(i, j, index, m, n);
            i = point.i;
            j = point.j;
        }
    }

    private static Point findNextPosition(int i, int j, int offset, int m, int n) {
        if (j == offset && i < m - 1 - offset) {
            return new Point(i+1, j);
        }
        if (i == m - 1 - offset && j < n - 1 - offset) {
            return new Point(i, j + 1);
        }
        if (j == n - 1 - offset && i > offset) {
            return new Point(i-1, j);
        }
        return new Point(i, j - 1);
    }

    private static void shift(List<Integer> layer, int r) {
        int shiftOffset = r % layer.size();
        if (shiftOffset == 0) {
            return;
        }
        int size = layer.size();
        for (int i = 0; i < shiftOffset; i++) {
            Integer last = layer.remove(size - 1);
            layer.add(0, last);
        }
    }

    private static List<Integer> findLayer(List<List<Integer>> matrix, int index) {
        List<Integer> col1 = new ArrayList<>();
        List<Integer> col2 = new ArrayList<>();
        int m = matrix.size();
        int n = matrix.get(0).size();
        for (int i = index; i < matrix.size() - index; i++) {
            Integer m1 = matrix.get(i).get(index);
            Integer m2 = matrix.get(m - 1 - i).get(n - 1 - index);
            col1.add(m1);
            col2.add(m2);
        }

        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        for (int i = index + 1; i < n - 1 - index; i++) {
            Integer r1 = matrix.get(m - 1 - index).get(i);
            Integer r2 = matrix.get(index).get(n - 1 - i);
            row1.add(r1);
            row2.add(r2);
        }
        List<Integer> layer = new ArrayList<>();
        layer.addAll(col1);
        layer.addAll(row1);
        layer.addAll(col2);
        layer.addAll(row2);
        return layer;
    }

    static class Point {
        public int i;
        public int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = asList(asList(1, 2, 3, 4), asList(5, 6, 7, 8), asList(9, 10, 11, 12), asList(13, 14, 15, 16));
        List<Integer> layer = findLayer(matrix, 0);
//        matrix.forEach(list -> {
//            String line = list.stream().map(i -> String.format("%2d", i)).collect(Collectors.joining(" "));
//            System.out.println(line);
//        });

        System.out.println();
        matrixRotation(matrix, 1);
    }
}
