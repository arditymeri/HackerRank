package fifthstar;

import java.util.List;

public class LisasWorkbook {

    public static int workbook(int n, int k, List<Integer> arr) {
        int page = 0;
        int total = 0;
        for(int i = 1; i <= arr.size(); i++) {
            int numExercises = arr.get(i-1);
            int pagesNeeded = (int) Math.ceil(numExercises / (double)k);
            for (int offset = 1; offset <= pagesNeeded; offset++) {
                if(hasSpecialExercise(page, offset, k, numExercises)) {
                    total ++;
                }
            }
            page += pagesNeeded;
        }

        return total;
    }

    private static boolean hasSpecialExercise(int page, int offset, int k, int numExercises) {
        int currentPage = page + offset;
        return currentPage<= k * offset
                && currentPage > (offset - 1) * k
                && currentPage <= numExercises;
    }
}
