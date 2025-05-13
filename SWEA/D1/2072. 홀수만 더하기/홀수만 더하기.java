import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수 t 입력받기
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            // 1. 해당 테스트 케이스의 모든 수 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 2. 합산
            int sum = 0;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                // 해당 수가 홀수라면 더하기
                if (num % 2 != 0) {
                    sum += num;
                }
            }

            // 3. 결과 출력
            System.out.printf("#%d %d\n", i, sum);
        }

        br.close();
    }
}