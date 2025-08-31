import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] timeTable = new int[100001];          // 이동 시 소모한 시간
        Queue<Integer> move = new LinkedList<>();   // 현재 이동한 위치
        timeTable[N] = 1;
        move.offer(N);

        // BFS 탐색 활용
        while (!move.isEmpty()) {
            int now = move.remove();

            if (now == K) {
                break;
            }

            // 1 감소
            if (0 <= now - 1 && timeTable[now - 1] == 0) {
                timeTable[now - 1] = timeTable[now] + 1;
                move.offer(now - 1);
            }

            // 1 증가
            if (now + 1 < timeTable.length && timeTable[now + 1] == 0) {
                timeTable[now + 1] = timeTable[now] + 1;
                move.offer(now + 1);
            }

            // 2배 증가
            if (now * 2 < timeTable.length && timeTable[now * 2] == 0) {
                timeTable[now * 2] = timeTable[now] + 1;
                move.offer(now * 2);
            }
        }

        // 결과 출력
        System.out.println(timeTable[K] - 1);
    }
}