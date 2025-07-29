import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        // maxScores[i] : i까지 올랐을 때의 최대 점수
        int[] maxScores = new int[n + 1];
        maxScores[1] = scores[1];
        if (n >= 2) {
            maxScores[2] = scores[1] + scores[2];
        }

        // 계단 오르기 수행
        for (int i = 3; i < scores.length; i++) {
            maxScores[i] = Math.max(maxScores[i - 2], scores[i - 1] + maxScores[i - 3]) + scores[i];
        }

        System.out.println(maxScores[n]);
    }
}

