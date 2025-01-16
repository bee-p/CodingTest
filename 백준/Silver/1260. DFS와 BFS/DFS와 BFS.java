import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 그래프
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 방문 정보 배열
    private static boolean[] dfsVisitedFlag;
    private static boolean[] bfsVisitedFlag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정점 개수, 간선 개수, 탐색을 시작할 정점 번호 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결 정보 입력받기
        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            // 양방향 입력
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        // 각 연결정보 정렬
        for (int i = 0; i <= n; i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        dfsVisitedFlag = new boolean[n + 1];
        bfsVisitedFlag = new boolean[n + 1];

        // DFS 수행
        dfsVisitedFlag[v] = true;
        doDFS(v);

        System.out.println();

        // BFS 수행
        bfsVisitedFlag[v] = true;
        doBFS(v);
    }

    private static void doDFS(int target) {
        System.out.print(target + " ");

        for (int node : graph.get(target)) {
            if (!dfsVisitedFlag[node]) {
                dfsVisitedFlag[node] = true;
                doDFS(node);
            }
        }
    }

    private static void doBFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while (!q.isEmpty()) {
            int target = q.poll();
            System.out.print(target + " ");

            for (int node : graph.get(target)) {
                if (!bfsVisitedFlag[node]) {
                    bfsVisitedFlag[node] = true;
                    q.offer(node);
                }
            }
        }
    }
}