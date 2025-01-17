import java.util.Scanner;

public class Main {
    static int m;
    static int n;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visitedFlag;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 수 입력받기
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            // 가로, 세로 길이, 배추 위치의 개수 입력받기
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            map = new int[m][n];
            visitedFlag = new boolean[m][n];
            int answer = 0;

            // 배추 위치 정보값 입력 받기
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[x][y] = 1;
            }

            // 모든 위치에 대해 탐색
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 배추가 있으면서 아직 방문하지 않은 곳이라면 탐색 시작
                    if (map[i][j] == 1 && !visitedFlag[i][j]) {
                        doDfs(i, j);
                        answer++;
                    }
                }
            }

            // 결과 출력
            System.out.println(answer);
        }
    }

    static void doDfs(int x, int y) {
        visitedFlag[x][y] = true;

        for (int i = 0; i < 4; i++) { // 상하좌우 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) { // 유효 범위 체크
                if (map[nx][ny] == 1 && !visitedFlag[nx][ny]) {
                    doDfs(nx, ny);
                }
            }
        }
    }
}