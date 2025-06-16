import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 개수 N 입력받기
        int n = Integer.parseInt(br.readLine());
        // 도로의 길이 목록 입력받기
        int[] roads = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }
        // 각 주유소의 리터당 가격 입력받기
        int[] costs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        // 제일 오른쪽 도시에 도착할 때까지 계산
        long sum = 0;       // 주유 비용 합계
        int nowPos = 0;     // 현재 위치 저장
        for (int dtPos = 1; dtPos < n; dtPos++) {
            // 현재 시작 지점과 그 다음 지점 가격 비교
            // 시작 지점 > 다음 지점이라면 다음 지점까지의 거리만큼만 주유
            if (costs[nowPos] > costs[dtPos] || dtPos == n - 1) {
                long add = 0;
                for (int k = nowPos; k < dtPos; k++) {
                    add += roads[k];
                }

                // 주유
                sum += costs[nowPos] * add;

                // 이후 위치로 이동
                nowPos = dtPos;
            }
        }

        // 결과 출력
        System.out.println(sum);
    }
}