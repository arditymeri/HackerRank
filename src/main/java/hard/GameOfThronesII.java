package hard;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfThronesII {

    private static final int MOD = (int) Math.pow(10, 9) + 7;

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
        List<Integer> nominators = Stream.iterate(1, i -> i + 1)
                .limit(halfSize)
                .collect(Collectors.toList());
        Collection<Long> denominatorFactorials = histogram.values();
        for (Long denominatorFactorial : denominatorFactorials) {
            List<Integer> denominators = Stream.iterate(1, i -> i + 1)
                    .limit(denominatorFactorial)
                    .collect(Collectors.toList());
            simplify(nominators, denominators);
        }
        return modMultiply(nominators);
    }

    private static int modMultiply(List<Integer>values) {
        BigInteger result = BigInteger.ONE;
        for (Integer value : values) {
            BigInteger biValue  = BigInteger.valueOf(value);
            result = (result.multiply(biValue)).mod(BigInteger.valueOf(MOD));
        }
        return result.intValue();
    }

    private static void simplify(List<Integer>nominators, List<Integer>denominators) {
        for(Integer denominator : denominators) {
            boolean found = false;
            for(int i = 0; i < nominators.size(); i++) {
                Integer nominator = nominators.get(i);
                if(nominator % denominator == 0) {
                    int r = nominator / denominator;
                    nominators.set(i, r);
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println("No simplifier found for: " + denominator);
                List<Integer> primeFactors = primeFactorisation(denominator);
                simplify(nominators, primeFactors);
            }

        }
    }

    private static List<Integer> primeFactorisation(Integer value) {
        List<Integer> primeFactors = new ArrayList<>();
        int number = value;
        for (int i = 2; i < number / 2; i++) {
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

    List<String> findPermutations(String value) {
        if (value.isEmpty()) {
            return Collections.emptyList();
        }

        if(value.length() == 1) {
            return Collections.singletonList(value);
        }
        List<String> permutations = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String remaining = value.substring(0, i) + value.substring(i+1);
            List<String> remainingPermutations = findPermutations(remaining);
            remainingPermutations.stream()
                    .map(p -> c + p)
                    .forEach(permutations::add);
        }
        return permutations;
    }

    public static void main(String[] args) {
//        GameOfThronesII got = new GameOfThronesII();
//        List<String> permutations = got.findPermutations("aaaabbbcde");
//        int size = permutations.size();
//        System.out.println(size);
//        System.out.println(size%31);
//
//        long distinct = permutations.stream().distinct().count();
//        System.out.println("Distinct: " + distinct);
//
//        System.out.println(solve("cdcdcdcdeeeef"));
//        System.out.println(solve("aaaabbbcde"));
//        System.out.println(solve("aaabbbb"));

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

//        int result = modMultiply(Arrays.asList(1000, 1000, 1001, 100000, 100000));
//        System.out.println(result);

    }
}
