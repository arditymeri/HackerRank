import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SalesByMatch {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        return Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()))
                .values()
                .stream()
                .map(integers -> integers.size() / 2)
                .reduce(0, Integer::sum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        int []values = {1, 2, 1, 1, 2, 3, 1, 2, 1, 3, 3, 3, 1};
        int []values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = sockMerchant(10, values);
        System.out.println("Result: " + result);

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] ar = new int[n];
//
//        String[] arItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arItem = Integer.parseInt(arItems[i]);
//            ar[i] = arItem;
//        }
//
//        int result = sockMerchant(n, ar);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
