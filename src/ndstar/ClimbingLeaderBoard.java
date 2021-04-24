package ndstar;

import java.util.*;
import java.util.stream.Collectors;

/**
 * An arcade game player wants to climb to the top of the leaderboard and track their ranking.
 * The game uses Dense Ranking, so its leaderboard works like this:
 *
 * <ul>
 *     <li>The player with the highest score is ranked number 1 on the leaderboard.</li>
 *     <li>Players who have equal scores receive the same ranking number, and the next player(s) receive the
 *     immediately following ranking number.</li>
 * </ul>
 */
public class ClimbingLeaderBoard {

    /**
     *
     * @param ranked sorted board in decreasing order
     * @param player games played
     * @return
     */
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        TreeSet<Integer> sorted = new TreeSet<>(Comparator.reverseOrder());
        sorted.addAll(ranked);
        List<Integer> climbingPositions = new ArrayList<>();
        for (Integer game : player) {
            sorted.add(game);
            int position = sorted.headSet(game).size() + 1;
            climbingPositions.add(position);
        }
        return climbingPositions;
    }

    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(100, 90, 90, 80, 75, 60);
        List<Integer> player = Arrays.asList(50, 65, 77, 90, 102);
        List<Integer> climbingList = climbingLeaderboard(ranked, player);
        String boardPositions = climbingList.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(boardPositions);
    }

}
