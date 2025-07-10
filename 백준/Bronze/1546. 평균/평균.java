import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 입력받기
        int n = Integer.parseInt(br.readLine());

        double[] scores = new double[n];
        double maxScore = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
            if (maxScore < scores[i]) {
                maxScore = scores[i];
            }
        }

        // 점수 계산
        double result = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = scores[i] / maxScore * 100;
            result += scores[i];
        }
        result /= n;

        // 결과 출력
        System.out.println(result);
    }
}