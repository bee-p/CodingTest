import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] fruits = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        // 만일 과일 개수가 2개 이하라면 최대 두 종류이므로 종료
        if (n <= 2) {
            System.out.println(n);
            return;
        }

        // 그게 아니라면 슬라이딩 윈도우 기법으로 검사
        HashMap<Integer, Integer> nowFruits = new HashMap<>();  // 과일 종류별 개수
        int left = 0;
        int maxCount = 0;   // 과일의 최대 개수
        for (int right = 0; right < n; right++) {
            nowFruits.put(fruits[right], nowFruits.getOrDefault(fruits[right], 0) + 1);

            // 과일 종류가 3개 이상이면 왼쪽 포인터 이동
            while (nowFruits.size() > 2) {
                nowFruits.replace(fruits[left], nowFruits.get(fruits[left]) - 1);
                if (nowFruits.get(fruits[left]) == 0) {
                    nowFruits.remove(fruits[left]);
                }
                left++;
            }

            // 과일의 최대 개수 비교 및 갱신
            maxCount = Math.max(maxCount, right - left + 1);
        }

        // 최종 결과 출력 (과일의 최대 개수 출력)
        System.out.println(maxCount);
    }
}