package fifthstar;

import java.util.List;

public class BeautifulTriplets {

    public static int beautifulTriplets(int d, List<Integer> arr) {
        int c = 0;
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = i + 1; j < arr.size() - 1; j++) {
                int ai = arr.get(i);
                int aj = arr.get(j);
                if(aj - ai == d) {
                    for (int k = j + 1; k < arr.size(); k++) {
                        int ak = arr.get(k);
                        if (isBeautiful(ai, aj, ak, d)) {
                            c++;
                        } else if(ak - aj > d) {
                            break;
                        }
                    }
                } else if(aj - ai > d) {
                    break;
                }
            }
        }
        return c;
    }

    private static boolean isBeautiful(Integer i, Integer j, Integer k, int d) {
        int d1 = j - i;
        int d2 = k - j;
        return d1 == d && d2 == d;
    }
}
