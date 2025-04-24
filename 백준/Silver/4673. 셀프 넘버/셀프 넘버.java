import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 ~ 10000 범위의 인덱스 사용
        final int MAX = 10001;
        boolean[] arr = new boolean[MAX];

        // d(n) 계산
        for (int n = 1; n < MAX; n++) {
            int dn = n + (n / 10000) + (n % 10000 / 1000) + (n % 1000 / 100) + (n % 100 / 10) + (n % 10);
            if (dn < MAX) {
                arr[dn] = true;
            }
        }

        // 결과 출력
        for (int n = 1; n < MAX; n++) {
            if (!arr[n]) {
                bw.write(n + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}