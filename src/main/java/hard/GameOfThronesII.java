package hard;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameOfThronesII {

    private static final BigInteger MOD = BigInteger.valueOf((int)Math.pow(10, 9) + 7);
    private static final Map<Integer, List<Integer>> primeFactorsMap = new HashMap<>();

    public static int solve(String s) {
        Map<String, Long> histogram = s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int size= s.length();

        for(Map.Entry<String, Long> entry : histogram.entrySet()) {
            Long value = entry.getValue();
            histogram.put(entry.getKey(), value/2);
        }

        int halfSize = size / 2;
        List<Long> denominatorFactorials = histogram.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> nominators = generateFactorialFactors(halfSize);
        nominators = maximizeNominators(nominators);
        for (Long denominatorFactorial : denominatorFactorials) {
            List<Integer> denominators = generateFactorialFactors(denominatorFactorial);
            simplify(nominators, denominators);
            nominators = maximizeNominators(nominators);
        }
        return modMultiply(nominators);
    }

    private static List<Integer> maximizeNominators(List<Integer> nominators) {
        List<Integer> maximised = new ArrayList<>();
        int size = nominators.size();
        int j = 0;
        for (int i = size - 1; i >= 0; i--) {
            BigInteger result = BigInteger.valueOf(nominators.get(i));
            while (j < i) {
                BigInteger t = result.multiply(BigInteger.valueOf(nominators.get(j)));
                if (t.compareTo(MOD) < 0) {
                    result = t;
                    j++;
                } else {
                    break;
                }
            }
            maximised.add(result.intValue());
            if(i == j) {
                break;
            }
        }
        return maximised;
    }

    private static List<Integer> generateFactorialFactors(long end) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= end; i++) {
            factors.add(i);
        }
        return factors;
    }

    private static int modMultiply(List<Integer>values) {
        BigInteger result = BigInteger.ONE;
        for (Integer value : values) {
            BigInteger bigValue = BigInteger.valueOf(value);
            result = (result.multiply(bigValue)).mod(MOD);
        }
        return result.intValue();
    }

    private static void simplify(List<Integer>nominators, List<Integer>denominators) {
        for(Integer denominator : denominators) {
            boolean found = false;
            for(int i = 0; i < nominators.size(); i++) {
                Integer nominator = nominators.get(i);
                if(nominator % denominator == 0) {
                    int r = nominator/denominator;
                    nominators.set(i, r);
                    found = true;
                    break;
                }
            }
            if(!found) {
                List<Integer> primeFactors;
                if(primeFactorsMap.containsKey(denominator)) {
                    primeFactors = primeFactorsMap.get(denominator);
                } else {
                    primeFactors = primeFactorisation(denominator);
                    primeFactorsMap.put(denominator, primeFactors);
                }
                simplify(nominators, primeFactors);
            }

        }
    }

    private static List<Integer> primeFactorisation(Integer value) {
        List<Integer> primeFactors = new ArrayList<>();
        int number = value;
        while (number % 2 == 0) {
            primeFactors.add(2);
            number /=2;
        }
        double limit = Math.sqrt(number);
        for (int i = 3; i <= limit; i+=2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }
        if(number > 2) {
            primeFactors.add(number);
        }
        return primeFactors;
    }
    public static void main(String[] args) {

        String sampleInput2 = "wklmxibigvaeqzigwbgysgfbvyvcqczmmnzlxatdxtjqvrwrucsmixpfvkhnniabxbnudizbejtzcpszrmlbkdih" +
                "nrvczxezytvdbvgfgzgiobhhnvkzyuhnleqndwmbrhgucnckmitdlcmzzzyzthnfnfsqdgtunaospqcdbximcvlbwmbpvqulvobyux" +
                "skzieozgtagcoizclvooklehwzvaxsxrcwaimbofbwjrgitsfhiqvnzrmwrmqqfumhcaitilprdwcwqhgyzbnaucxoqnevitdktldd" +
                "zvxcrzajigjkjxkgzjupxymhrprndxsespglqiwbpflacxgdhaugbhnuygjddchxtpkmygnpmarqxyweaqkdzzyaghdllljhcvtacg" +
                "rqgjidjgkjzwpywnycwepirartwkwaqnqwyabhhntgkiggvhktlzdccuxyetyuhqsfswpzjihtqqbnxlgknkopelplfnfofavxwkzh" +
                "sgbkyexxsghfsvwwjljoapehrzepkdwemxrmcqkuwtborznamwoonsvetbtfhqkvpdhtttpqnseertedqutfookhqfnzxzuncbgvvy" +
                "nkquoknsnfojlcxxlpcaoabipfmxdjvqtokhyabnfrwstwpgluhcwkmlqyktjijcwwluwmhddeyycphnlqrhaeuqefjopvslrefpqo" +
                "uwuswwkdmvtddujzmqgwevrwgkanbtevryqpxatjxoockacxqivwgosmyvczqgwjgmydotmoidqsdurvdmrlajzygbzyhwhqkitbbi" +
                "pllfgqaxlfmcsmnrnwtoucmesxooapwpdjwlzyimfuoxjdpwzkkwoxajwoxyftnkclvbmgptadrliijiuweitgrrwqpbjemlrjodpd" +
                "zsisdranbwjhgenaxjqomasanlkcpzhqrqixjkmkgvrmbgbdhijklnpqtvwz";
        int sampleOutput2 = solve(sampleInput2);
        System.out.println(sampleOutput2);

    }
}
