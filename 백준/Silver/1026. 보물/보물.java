import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

        // N 입력받기
        int n = Integer.parseInt(br.readLine());

        // A, B의 요소 입력받기
        Integer[] aList = new Integer[n];
        Integer[] bList = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bList[i] = Integer.parseInt(st.nextToken());
        }

        // 각 요소 서로 반대로 정렬
        Arrays.sort(aList);
        Arrays.sort(bList, Comparator.reverseOrder());

        // S(result) 구하기
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += aList[i] * bList[i];
        }

        bw.write("" + result);
        bw.flush();
        bw.close();
    }
}