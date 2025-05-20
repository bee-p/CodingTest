import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            // 1. 덤프 횟수, 상자의 높이 입력받기
            int count = Integer.parseInt(br.readLine());
            int[] boxes = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 2. 계산
            Arrays.sort(boxes);
            while (count > 0) {
                boxes[0]++;
                boxes[99]--;
                count--;
                Arrays.sort(boxes);
            }

            // 3. 결과 출력
            System.out.printf("#%d %d\n", t, boxes[99] - boxes[0]);
        }
    }
}