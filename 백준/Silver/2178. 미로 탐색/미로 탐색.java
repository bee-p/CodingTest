import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 미로의 크기 n, m 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 미로 데이터 입력받기
        int[][] map = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 상하좌우 이동 배열
        Pair[] moveList = {new Pair(-1, 0), new Pair(1, 0),
                new Pair(0, -1), new Pair(0, 1)};

        // BFS 탐색 수행
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair now = q.poll();

            // 상하좌우 다 탐색
            for (Pair move : moveList) {
                int dx = now.x + move.x;
                int dy = now.y + move.y;

                // 갈 수 있는 곳을 찾았다면
                if (0 <= dx && dx < n && 0 <= dy && dy < m
                        && map[dx][dy] == 1) {
                    map[dx][dy] = map[now.x][now.y] + 1;
                    q.offer(new Pair(dx, dy));
                }
            }
        }

        System.out.println(map[n - 1][m - 1]);
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}