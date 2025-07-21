import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for (int n = 0; n < N; n++) {
            char[] input = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                // 칸의 색상이 흰색이면 true, 검은색이면 false
                if (input[m] == 'W') {
                    map[n][m] = true;
                }
            }
        }

        int minCount = Integer.MAX_VALUE;

        // 8x8 윈도우 검색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 실질적인 계산
                int result = search(i, j);

                // 최소값 갱신
                if (result < minCount) {
                    minCount = result;
                }
            }
        }

        System.out.println(minCount);
    }

    static int search(int x, int y) {
        boolean flag = map[x][y];
        int count = 0;  // 다시 색칠해야 하는 수

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // 있어야 하는 색이 아니면 count 증가
                if (map[i][j] != flag) {
                    count++;
                }

                // 색이 번갈아 가면서 나와야 하므로 플래그 반전
                flag = !flag;
            }

            // 한 줄의 맨 마지막 색과 다음 줄의 첫 번째 색은 같아야 하므로 다시 반전
            flag = !flag;
        }

        // 첫 번재 칸을 W로 만들었을 때와 B로 만들었을 때를 비교하여
        // 더 작은 횟수를 반환
        return Math.min(count, 64 - count);
    }
}