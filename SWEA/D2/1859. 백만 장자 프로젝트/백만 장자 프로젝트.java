import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수 t 입력받기
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            // 1. 해당 테스트 케이스의 날짜와 모든 수 입력받기
            int day = Integer.parseInt(br.readLine());
            int[] info = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 2. 이익 계산
            long sum = 0;
            int maxCost = info[day - 1];
            for (int k = day - 1; k >= 0; k--) {
                if (info[k] < maxCost) {
                    sum += maxCost - info[k];
                } else {
                    maxCost = info[k];
                }
            }

            // 3. 결과 출력
            System.out.printf("#%d %d\n", i, sum);
        }

        br.close();
    }
}