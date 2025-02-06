import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            pairs[i][0] = Integer.parseInt(str[0]);
            pairs[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(pairs, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            } else {
                return p1[0] - p2[0];
            }
        });

        for (int[] pair : pairs) {
            bw.write(pair[0] + " " + pair[1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}