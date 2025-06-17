import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기 N, M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 각 행렬의 원소 값 받기
        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 출발 지점에 대해서 모두 검사, 최적의 값 찾기
        for (int m = 0; m < M; m++) {
            search(0, m, -1, 0);
        }

        // 결과 출력
        System.out.println(minCost);
    }

    /**
    lastMove: 이전에 이동한 방향을 의미
     0: 왼쪽 아래 이동
     1: 가운데 아래 이동
     2: 오른쪽 아래 이동
    **/
    static void search(int x, int y, int lastMove, int nowCost) {
        // 범위에 벗어나면 종료
        if (y < 0 || M <= y) {
            return;
        }

        // 달 위치에 도달했다면
        if (N <= x) {
            // 최소값 갱신 후 종료
            minCost = nowCost;
            return;
        }

        // 현재 위치의 비용 더하기
        nowCost += map[x][y];

        // 현재 누적된 비용이 최소값보다 같거나 많으면 종료
        if (minCost <= nowCost) {
            return;
        }

        // 각 위치 이동 및 탐색 (같은 방향으로 두 번 연속 가지 않도록 함)
        // 왼쪽 아래
        if (lastMove != 0) {
            search(x + 1, y - 1, 0, nowCost);
        }
        // 가운데 아래
        if (lastMove != 1) {
            search(x + 1, y, 1, nowCost);
        }
        // 오른쪽 아래
        if (lastMove != 2) {
            search(x + 1, y + 1, 2, nowCost);
        }
    }
}