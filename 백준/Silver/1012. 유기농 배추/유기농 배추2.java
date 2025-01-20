import java.util.Scanner;

public class Main {
    private static int[][] map;
    private static int m;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 수 입력받기
        int T = sc.nextInt();

        // 테스트 케이스만큼 수행
        for (int t = 0; t < T; t++) {
            int answer = 0;

            // 가로와 세로 길이, 심어진 개수 입력받기
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            // map 생성 및 배추 위치 데이터 입력받기
            map = new int[m][n];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[x][y] = 1;
            }

            // 탐색
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 해당 위치에 배추가 있다면 탐색 시작
                    if (map[i][j] == 1) {
                        answer++;
                        doDfs(i, j);
                    }
                }
            }

            // 답안 출력
            System.out.println(answer);
        }
    }

    private static boolean isInBounds(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    private static void doDfs(int x, int y) {
        if (isInBounds(x, y) && map[x][y] == 1) {
            // 해당 위치의 배추 없애기 (탐색 완료 판정)
            map[x][y] = 0;

            // 상하좌우 탐색
            doDfs(x - 1, y);
            doDfs(x + 1, y);
            doDfs(x, y - 1);
            doDfs(x, y + 1);
        }
    }
}
