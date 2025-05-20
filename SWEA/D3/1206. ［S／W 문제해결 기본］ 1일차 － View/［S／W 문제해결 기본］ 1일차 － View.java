import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            // 1. 해당 테스트 케이스의 건물 수와 건물의 높이 입력받기
            int count = Integer.parseInt(br.readLine());
            int[] info = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 2. 조망권 계산
            int end = count - 2;
            int sum = 0;
            for (int i = 2; i < end; i++) {
                // 1) 왼쪽 확인
                int left = Math.min(info[i] - info[i - 1], info[i] - info[i - 2]);

                // 2) 오른쪽 확인
                int right = Math.min(info[i] - info[i + 1], info[i] - info[i + 2]);

                // 3) 최종 조망권 계산 및 합산
                int good = Math.min(left, right);
                if (good > 0) {
                    sum += good;
                }
            }

            // 3. 결과 출력
            System.out.printf("#%d %d\n", t, sum);
        }
    }
}