import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // N 입력받기
        int n = Integer.parseInt(br.readLine());

        // n번째 영화를 구할 때까지 반복
        int num = 665;
        for (int i = 0; i < n; ) {
            num++;

            if (String.valueOf(num).contains("666")) {
                i++;
            }
        }

        bw.write("" + num);
        bw.flush();
        bw.close();
    }
}