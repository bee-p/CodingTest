import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 0번 인덱스는 사용X
        // arr[i] : 첫 번째부터 i번째까지의 수의 합을 저장
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 구간 출력
        // a ~ b 구간일 경우, arr[b] - arr[a - 1]로 합을 구함
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(arr[j] - arr[i - 1]).append("\n");
        }
        System.out.println(sb);
    }
}

