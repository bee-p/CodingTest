import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static int[][] map;
    private static int n;
    private static int homeCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 지도의 크기 입력받기
        n = sc.nextInt();

        // 맵 정보 입력받기
        sc.nextLine();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] arr = sc.nextLine().toCharArray();

            for (int j = 0; j < n; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        // 단지 내 집 수 배열
        ArrayList<Integer> homeCountArr = new ArrayList<>();

        // 탐색 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 집이 발견됐다면
                if (map[i][j] == 1) {
                    // 집 수 초기화
                    homeCount = 0;

                    // dfs 수행
                    doDfs(i, j);

                    // 단지 별 집 수 추가
                    homeCountArr.add(homeCount);
                }
            }
        }

        // 답 출력
        System.out.println(homeCountArr.size());
        homeCountArr.sort(Comparator.naturalOrder());
        for (int count : homeCountArr) {
            System.out.println(count);
        }
    }

    private static boolean isInBounds(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    private static void doDfs(int x, int y) {
        if (isInBounds(x, y) && map[x][y] == 1) {
            // 해당 위치의 집 없애기 (탐색 완료 판정)
            map[x][y] = 0;
            homeCount++;

            // 상하좌우 탐색
            doDfs(x - 1, y);
            doDfs(x + 1, y);
            doDfs(x, y - 1);
            doDfs(x, y + 1);
        }
    }
}