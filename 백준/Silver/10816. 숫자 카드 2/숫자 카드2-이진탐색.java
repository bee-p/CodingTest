import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int[] cardList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 데이터 입력받기
        int n = Integer.parseInt(br.readLine());
        cardList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = Integer.parseInt(br.readLine());
        int[] targetList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 정렬 후 탐색
        Arrays.sort(cardList);
        for (int i = 0; i < m; i++) {
            int target = targetList[i];
            bw.write(findUpperIndex(target) - findLowerIndex(target) + " ");
        }

        bw.flush();
        bw.close();
    }

    // 탐색범위 : start <= x < end
    static int findLowerIndex(int key) {
        int start = 0;
        int end = cardList.length;

        // start == end면 탐색 종료
        while (start < end) {
            int mid = (start + end) / 2;

            if (key <= cardList[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    // 탐색범위 : start <= x < end
    static int findUpperIndex(int key) {
        int start = 0;
        int end = cardList.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (cardList[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
