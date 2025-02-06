import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static Integer[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 데이터 입력받기
        String[] inputStr = br.readLine().split(" ");
        int n = Integer.parseInt(inputStr[0]);
        int m = Integer.parseInt(inputStr[1]);
        trees = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        // 데이터 정렬
        Arrays.sort(trees, Comparator.reverseOrder());

        System.out.println(binarySearch(n, m));
    }

    static int binarySearch(int treesSize, int target) {
        int low = 0;
        int high = trees[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for (int i = 0; i < treesSize; i++) {
                if (trees[i] <= mid) {
                    break;
                }

                sum += trees[i] - mid;
            }

            if (sum == target) {
                return mid;
            }
            else if (target < sum) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }
}