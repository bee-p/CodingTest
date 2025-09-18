import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};   // 상하좌우 이동 배열
    static Queue<Pos> visitedQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        m = Integer.parseInt(input.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];

        int nowX = 0;
        int nowY = 0;
        for (int i = 0; i < n; i++) {
            input = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input.nextToken());

                if (map[i][j] == 2) {
                    nowX = i;
                    nowY = j;
                }
            }
        }

        map[nowX][nowY] = 0;
        visitedQueue.offer(new Pos(nowX, nowY, 0));
        doSearch();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 도달할 수 없었던 위치라면 -1 출력
                if (!isVisited[i][j] && map[i][j] == 1) {
                    output.append(-1).append(' ');
                } else {
                    output.append(map[i][j]).append(' ');
                }
            }
            output.append('\n');
        }

        System.out.println(output);
    }

    // 범위 체크 메소드
    static boolean isBounded(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    // BFS 활용
    static void doSearch() {
        while (!visitedQueue.isEmpty()) {
            Pos now = visitedQueue.poll();
            isVisited[now.x][now.y] = true;

            // 상하좌우 인접 땅 방문
            for (int[] movePos : move) {
                int moveX = now.x + movePos[0];
                int moveY = now.y + movePos[1];

                if (isBounded(moveX, moveY) && !isVisited[moveX][moveY] && map[moveX][moveY] != 0) {
                    // 현재 위치 방문 표시
                    isVisited[moveX][moveY] = true;

                    // 목적지까지의 길이 표시
                    map[moveX][moveY] = now.depth + 1;

                    visitedQueue.offer(new Pos(moveX, moveY, now.depth + 1));
                }
            }
        }
    }
}

class Pos {
    int x;
    int y;
    int depth;

    Pos(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

