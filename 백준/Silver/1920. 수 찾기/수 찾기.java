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
            int result = binarySearch(targetList[i], 0, n - 1);

            if (result != -1) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static int binarySearch(int key, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (cardList[mid] == key) {
                return mid;
            } else if (key < cardList[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // 탐색 실패 시 -1 반환
        return -1;
    }
}