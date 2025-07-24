import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 에라토스테네스의 체 방법을 이용해 전체 검사하기
        boolean[] isNotPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            // 소수가 아닌 수는 배수 검사X
            if (isNotPrime[i]) {
                continue;
            }

            // 출력해야 하는 범위면 출력
            if (i >= m) {
                bw.write(i + "\n");
            }

            // 해당 소수의 배수 검사
            for (int k = 2; i * k <= n; k++) {
                isNotPrime[i * k] = true;
            }
        }

        bw.flush();
        bw.close();
    }
}