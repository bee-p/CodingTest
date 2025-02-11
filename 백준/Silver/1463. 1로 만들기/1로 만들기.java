import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 연산 시작 (bottom-up 방식)
        int[] count = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // 1 빼기
            count[i] = count[i - 1] + 1;
            // 2로 나누기
            if (i % 2 == 0) {
                count[i] = Math.min(count[i], count[i / 2] + 1);
            }
            // 3으로 나누기
            if (i % 3 == 0) {
                count[i] = Math.min(count[i], count[i / 3] + 1);
            }
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count[n] + "");
        bw.flush();
        bw.close();
    }
}