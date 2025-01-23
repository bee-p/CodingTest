import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 단어의 개수 입력받기
        int n = Integer.parseInt(br.readLine());

        // 데이터 입력받기
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        // 정렬 수행
        Arrays.sort(arr, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            else {
                return s1.length() - s2.length();
            }
        });

        // 출력
        bw.write(arr[0] + '\n');
        for (int i = 1; i < n; i++) {
            // 중복 제거
            if (!arr[i].equals(arr[i - 1])) {
                bw.write(arr[i] + '\n');
            }
        }
        bw.flush();
        bw.close();
    }
}