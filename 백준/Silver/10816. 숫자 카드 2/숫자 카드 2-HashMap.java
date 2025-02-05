import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 데이터 입력받기
        int n = Integer.parseInt(br.readLine());
        String[] cardStr = br.readLine().split(" ");

        // key: 숫자, value: 숫자가 등장한 횟수
        HashMap<Integer, Integer> cardMap = new HashMap<>();
        for (String card : cardStr) {
            int cardInt = Integer.parseInt(card);
            cardMap.put(cardInt, cardMap.getOrDefault(cardInt, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        int[] targetList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 해당 값 가져오기
        for (int i = 0; i < m; i++) {
            bw.write(cardMap.getOrDefault(targetList[i], 0) + " ");
        }

        bw.flush();
        bw.close();
    }
}
