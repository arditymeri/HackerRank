package fifthstar;

import java.util.List;

public class MinimumDistances {

    public static int minimumDistances(List<Integer> a) {
        int minDistance = a.size();
        for (int i = 0; i < a.size(); i++) {
            int ai = a.get(i);
            int distance = findMinDistance(ai, i, a);
            if (distance >= 0 && distance < minDistance) {
                minDistance = distance;
            }
        }
        return minDistance == a.size() ? -1 : minDistance;

    }

    private static int findMinDistance(int ai, int i, List<Integer> a) {
        for (int j = i + 1; j < a.size(); j ++) {
            int aj = a.get(j);
            if (ai == aj) {
                return j - i;
            }
        }
        return -1;
    }
}
