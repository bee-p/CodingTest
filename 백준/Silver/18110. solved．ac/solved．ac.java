import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(scores);

        // 평균 계산
        int removeCount = (int) Math.round(n * (15 / 100.0));
        int end = n - removeCount;
        int sum = 0;
        for (int i = removeCount; i < end; i++) {
            sum += scores[i];
        }

        double minusN = n - (removeCount * 2);
        System.out.println((int) Math.round(sum / minusN));
    }
}