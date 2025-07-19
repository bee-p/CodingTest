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

        int n = Integer.parseInt(br.readLine());

        // result[i][j]에 i ~ j 까지의 수가 팰린드롬인지의 여부를 저장하기 위함
        // 팰린드롬이라면 1, 아니라면 0 저장
        int[][] result = new int[n][n];

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 팰린드롬 계산
        for (int e = 0; e < n; e++) {
            for (int s = 0; s <= e; s++) {
                // 범위가 1일 경우
                if (s == e) {
                    result[s][e] = 1;
                }
                // 범위가 2일 경우
                else if (e - s == 1) {
                    // 두 수가 같다면 팰린드롬
                    if (arr[s] == arr[e]) {
                        result[s][e] = 1;
                    }
                }
                // 범위가 3 이상일 경우
                else {
                    // 두 수가 같고, 더 작은 범위가 이미 팰린드롬이라면 팰린드롬
                    if (arr[s] == arr[e] && result[s + 1][e - 1] == 1) {
                        result[s][e] = 1;
                    }
                }
            }
        }

        // 질문 받고 출력
        int m = Integer.parseInt(br.readLine());
        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            bw.write(result[s][e] + "\n");
        }

        bw.flush();
        bw.close();
    }
}