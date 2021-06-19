package rdstar;

import java.util.List;

public class AngryProfessor {

    public static String angryProfessor(int k, List<Integer> a) {
        int present = (int) a.stream()
                .filter(i -> i<=0)
                .count();
        return present < k ? "YES" : "NO";
    }
}
