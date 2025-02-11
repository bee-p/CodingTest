import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수 받기
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            // 초기 값 세팅
            int[] count = new int[n + 1];
            count[1] = 1;
            if (n >= 2) count[2] = 2;
            if (n >= 3) count[3] = 4;

            for (int i = 4; i <= n; i++) {
                count[i] = count[i - 1] + count[i - 2] + count[i - 3];
            }

            // 결과 출력
            System.out.println(count[n]);
        }
    }
}