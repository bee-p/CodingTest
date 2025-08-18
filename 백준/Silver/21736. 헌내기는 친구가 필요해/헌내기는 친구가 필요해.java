import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] isVisited;
    static int n, m;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n][m];
        map = new char[n][m];
        int nowX = 0;
        int nowY = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);

                // 현재 도연의 위치 파악
                if (map[i][j] == 'I') {
                    nowX = i;
                    nowY = j;
                }
            }
        }

        doBfs(nowX, nowY);

        if (result != 0) {
            System.out.println(result);
        } else {
            System.out.println("TT");
        }
    }

    static void doBfs(int x, int y) {
        // map 범위 넘어가면 종료
        if (x < 0 || n <= x || y < 0 || m <= y) {
            return;
        }

        // 이미 탐색한 곳이면 종료
        if (isVisited[x][y]) {
            return;
        }

        // 벽을 만나면 종료
        if (map[x][y] == 'X') {
            return;
        }

        // 현재 위치 방문 체크
        isVisited[x][y] = true;

        // 만약 사람을 만났다면 카운트
        if (map[x][y] == 'P') {
            result++;
        }

        // 이후 범위 탐색 (상하좌우)
        doBfs(x - 1, y);
        doBfs(x + 1, y);
        doBfs(x, y - 1);
        doBfs(x, y + 1);
    }
}

