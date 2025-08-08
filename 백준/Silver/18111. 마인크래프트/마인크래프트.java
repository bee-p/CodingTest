import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        int b = Integer.parseInt(input.nextToken());

        int[] map = new int[n * m];
        int maxH = -1;
        int minH = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            input = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                map[index] = Integer.parseInt(input.nextToken());

                if (maxH < map[index]) {
                    maxH = map[index];
                }
                if (map[index] < minH) {
                    minH = map[index];
                }
            }
        }

        int minTime = Integer.MAX_VALUE;
        int resultH = 0;

        // 만들 수 있는 높이 별로 각각 계산해 최소 시간을 구함
        for (int now = minH; now <= maxH; now++) {
            int stackBlock = b;
            int usedBlock = 0;
            int time = 0;

            for (int i = 0; i < map.length; i++) {
                // 추가 획득 블록 계산 (땅 캐기) - 2초 소요
                if (now < map[i]) {
                    stackBlock += map[i] - now;
                    time += (map[i] - now) * 2;
                }
                // 땅 채우기 계산 - 1초 소요
                else if (map[i] < now) {
                    usedBlock += now - map[i];
                    time += (now - map[i]);
                }
            }

            // 해당 높이를 만들 수 있는 경우
            if (usedBlock <= stackBlock) {
                // 최소 시간을 단축했다면 저장
                // 걸리는 시간이 같다면 땅의 높이가 높은 것을 저장할 수 있도록 함
                if (time <= minTime) {
                    minTime = time;
                    resultH = now;
                }
            } else {
                break;
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(minTime).append(" ").append(resultH);
        System.out.println(output);
    }
}