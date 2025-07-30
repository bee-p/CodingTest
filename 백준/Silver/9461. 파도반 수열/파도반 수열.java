import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // P(100)까지의 수열 미리 구해놓기
        long[] seq = new long[101];
        seq[1] = seq[2] = seq[3] = 1;
        for (int i = 4; i < seq.length; i++) {
            seq[i] = seq[i - 3] + seq[i - 2];
        }

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(seq[n]).append("\n");
        }
        System.out.println(sb);
    }
}

