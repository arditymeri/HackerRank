package rdstar;

import java.util.*;
import java.util.stream.Collectors;

public class DesignerPDFViewer {

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        int maxHeight = word.chars().map(c -> h.get(c - 97)).max().orElse(0);
        return maxHeight * word.length();

    }

    public static void main(String[] args) {
        int []h = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
        String word = "zaba";
        List<Integer> heights = Arrays.stream(h).boxed().collect(Collectors.toList());
        int surface = designerPdfViewer(heights, word);
        System.out.println(surface);

    }
}
