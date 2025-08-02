import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // dp[i] : 합이 i와 같게 되는 제곱수들의 최소 개수
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 기본적으로 이전 숫자보다 1개 더 많으니 이전 값을 저장
            dp[i] = dp[i - 1];
            // 더 이전 제곱수들을 더했을 때 개수가 줄어드는지 체크
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]);
            }
            dp[i]++;
        }

        System.out.println(dp[n]);
    }
}

