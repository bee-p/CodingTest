import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // map.get(1) = [2, 3] --> 1번 노드에 2번, 3번이 연결되어 있다는 뜻
    static List<Queue<Integer>> map = new ArrayList<>();
    // 각 노드의 방문 체크를 위함
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

        // 입력 정점 숫자를 그대로 사용하기 위해 0번 인덱스는 사용X
        for (int i = 0; i <= n; i++) {
            map.add(new LinkedList<>());
        }

        // 간선 정보 저장
        for (int t = 0; t < m; t++) {
            input = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(input.nextToken());
            int node2 = Integer.parseInt(input.nextToken());

            map.get(node1).offer(node2);
            map.get(node2).offer(node1);
        }

        // 연결 요소 계산
        int result = 0;
        isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                searchList(i);
                result++;
            }
        }

        System.out.println(result);
    }

    // 연결된 정점을 찾아 탐색하는 메소드
    static void searchList(int now) {
        // 해당 노드를 이미 방문했다면 종료
        if (isVisited[now]) {
            return;
        }

        // 현재 노드 방문 처리
        isVisited[now] = true;

        // 연결된 정점 정보 탐색
        while (!map.get(now).isEmpty()) {
            searchList(map.get(now).poll());
        }
    }
}