import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 입력받기
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 소수 계산
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)   continue;
            if (nums[i] != 2 && nums[i] % 2 == 0)   continue;

            boolean isPrime = true;
            for (int k = 3; k < nums[i]; k += 2) {
                if (nums[i] % k == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                result++;
            }
        }

        System.out.println(result);
    }
}