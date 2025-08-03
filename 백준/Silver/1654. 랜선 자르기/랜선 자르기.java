import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // K, N 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int targetCount = Integer.parseInt(st.nextToken());

        int[] lines = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());

            if (max < lines[i]) {
                max = lines[i];
            }
        }

        int makeCount;
        long nowLine;
        long min = 1;
        max++;  // 랜선 max 값이 결과적으로 최대값일 경우를 대비해 1 증가시킴

        while (min < max) {
            // 1. 현재 범위에서 중간 길이 구하기
            nowLine = (min + max) / 2;

            // 2. 중간 길이로 만들어지는 랜선 개수 카운트
            makeCount = 0;
            for (int i = 0; i < k; i++) {
                makeCount += lines[i] / nowLine;
            }

            // 3. upper bound 형식으로 이진탐색 수행 (길이 범위 재설정)
            if (makeCount < targetCount) {
                max = nowLine;
            } else {
                min = nowLine + 1;
            }
        }

        System.out.println(min - 1);
    }
}