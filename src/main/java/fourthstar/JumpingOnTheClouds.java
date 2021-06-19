package fourthstar;

import java.util.Arrays;
import java.util.List;

public class JumpingOnTheClouds {

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;
        int zCount=0;
        for (Integer value : c) {
            if(value == 1) {
                int newJumps = (zCount / 2) + 1;
                jumps += newJumps;
                zCount = 0;
            } else {
                zCount++;
            }
        }
        jumps += zCount / 2;
        return jumps;
    }

    public static void main(String[] args) {
//        int result = jumpingOnClouds(Arrays.asList(0, 0, 0, 1, 0, 0));
        int result = jumpingOnClouds(Arrays.asList(0, 0, 1, 0, 0, 1, 0));
        System.out.println(result);
    }
}
