import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] relation = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                relation[i][j] = 9999999;
            }
            relation[i][i] = 0; // 자기 자신은 거리가 0
        }

        // 관계 입력
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = relation[b][a] = 1;
        }

        // 케빈 베이컨의 수 계산 (플로이드 워셜 알고리즘 사용)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (relation[i][j] > relation[i][k] + relation[k][j]) {
                        relation[i][j] = relation[i][k] + relation[k][j];
                    }
                }
            }
        }

        // 결과 도출
        int minSum = 9999999;
        int result = 0;
        for (int i = n; i > 0; i--) {
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                sum += relation[i][j];
            }

            if (minSum >= sum) {
                minSum = sum;
                result = i;
            }
        }

        System.out.println(result);
    }
}