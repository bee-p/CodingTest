import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // dp[i] : 2 x i 크기의 직사각형을 채우는 방법의 수를 담음
        // dp[0]은 사용X
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2) dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            // 2x2 크기를 채우는 방법이 (세로 직사각형 제외) 2가지이므로
            // dp[i - 2]번째의 모양이 포함되는 상황이 해당 경우에서 2번 등장함
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}

