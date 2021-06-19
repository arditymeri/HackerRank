package fifthstar;

import java.util.Arrays;
import java.util.List;

public class ACMICPCTeam {

    public static List<Integer> acmTeam(List<String> topic) {
        int[][] topics = new int[topic.size()][topic.get(0).length()];
        int ii = 0;
        int n = topics.length;
        for (String aTopic : topic) {
            int[] topicArray = aTopic
                    .chars()
                    .mapToObj(charValue -> Character.toString((char) charValue))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
            topics[ii] = topicArray;
            ii++;
        }

        int max = 0;
        int numTeams = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int val = calcMax(topics[i], topics[j]);
                if (val > max) {
                    max = val;
                    numTeams = 1;
                } else if (val == max) {
                    numTeams++;
                }
            }
        }
        return Arrays.asList(max, numTeams);
    }

    private static int calcMax(int[] topic, int[] topic1) {
        int sum = 0;
        for (int i = 0; i < topic.length; i++) {
            sum += Math.min(1, topic[i] + topic1[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<String> values = Arrays.asList("10101", "11100", "11010", "00101");
        List<Integer> result = acmTeam(values);
        result.forEach(System.out::println);
    }
}
