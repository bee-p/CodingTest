import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        // 컴퓨터의 수, 연결되어 있는 수 입력받기
        int n = sc.nextInt();
        int pairCount = sc.nextInt();

        // 그래프 초기화, 1번째부터 1번 컴퓨터 기록
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결 정보 입력받기
        for (int i = 0; i < pairCount; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            // 연결 정보 양방향 입력
            graph.get(c1).add(c2);
            graph.get(c2).add(c1);
        }

        // 방문 정보 저장 배열 초기화
        boolean[] visitedFlag = new boolean[n + 1];
        // BFS 탐색을 위한 큐
        Queue<Integer> q = new LinkedList<>();

        // 탐색 시작 - 1번 컴퓨터부터
        int targetNode = 1;
        visitedFlag[targetNode] = true;
        q.offer(targetNode);

        while (!q.isEmpty()) {
            targetNode = q.poll();

            for (int node : graph.get(targetNode)) {
                if (!visitedFlag[node]) {
                    answer++;
                    visitedFlag[node] = true;
                    q.offer(node);
                }
            }
        }

        System.out.println(answer);
    }
}