import java.io.*;

public class CountingValleys {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        char[] stepLetters = path.toCharArray();
        int valleys = 0;
        int level = 0;
        for (int i = 0; i < stepLetters.length; i++) {
            char step = stepLetters[i];
            if(level != 0) {
                if('U' == step) {
                    level++;
                } else {
                    level--;
                }
            } else {
                if(step == 'D') {
                    int valleyLength = findValleyLength(i, stepLetters);
                    if(valleyLength > 0) {
                        i += valleyLength - 1;
                        valleys++;
                    }
                } else {
                    level ++;
                }
            }
        }
        return valleys;
    }

    private static int findValleyLength(int index, char[] stepLetters) {
        int valleyLength = 0;
        int level = 0;

        for(int i = index; i < stepLetters.length; i++) {
            char step = stepLetters[i];
            if(step == 'D') {
                level --;
            } else if (step == 'U'){
                level ++;
            }
            valleyLength++;
            if(level == 0) {
                break;
            }

            if(i == stepLetters.length - 1) {
                return -1;
            }

        }
        return valleyLength;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {

        int result = CountingValleys.countingValleys(1, "DUDDUUDUDU");
        System.out.println("Result: " + result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int steps = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String path = bufferedReader.readLine();
//
//        int result = CountingValleys.countingValleys(steps, path);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
