import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        final int INF = Integer.MAX_VALUE;
        final int[][] moveList = new int[][]{
                {-1, 0},    // 상
                {1, 0},     // 하
                {0, -1},    // 좌
                {0, 1}};    // 우
        int tCount = 0; // 테스트 케이스 개수

        while (true) {
            // 동굴의 크기 입력받기
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] map = new int[n][n];

            // 도둑루피의 크기 입력받기
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 출발지로부터의 거리(도둑루피의 수) 저장
            int[][] dist = new int[n][n];
            for (int[] arr : dist) {
                Arrays.fill(arr, INF);
            }

            // 방문 정보 저장
            boolean[][] visitedFlag = new boolean[n][n];
            PriorityQueue<Space> pq = new PriorityQueue<>();

            // 출발지 표시
            dist[0][0] = map[0][0];
            pq.offer(new Space(0, 0, map[0][0]));

            // 최단 경로 찾기 - 다익스트라 알고리즘 이용
            while (!pq.isEmpty()) {
                Space now = pq.poll();

                // 이미 방문한 곳이라면 넘김
                if (visitedFlag[now.x][now.y]) {
                    continue;
                }

                // 방문하지 않았다면 인접 공간 탐색
                visitedFlag[now.x][now.y] = true;
                for (int[] move : moveList) {
                    int dx = now.x + move[0];
                    int dy = now.y + move[1];

                    // 동굴 범위 안에 있다면
                    if (0 <= dx && dx < n && 0 <= dy && dy < n) {
                        // 더 최단 거리라면 값 갱신
                        if (dist[now.x][now.y] + map[dx][dy] < dist[dx][dy]) {
                            dist[dx][dy] = dist[now.x][now.y] + map[dx][dy];
                            pq.offer(new Space(dx, dy, dist[dx][dy]));
                        }
                    }
                }
            }

            // 결과 출력
            tCount++;
            bw.write("Problem " + tCount + ": " + dist[n - 1][n - 1] + "\n");
            bw.flush();
        }

        bw.close();
    }

    static class Space implements Comparable<Space> {
        int x;
        int y;
        int rupee;

        Space(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        @Override
        public int compareTo(Space o) {
            return this.rupee - o.rupee;
        }
    }
}