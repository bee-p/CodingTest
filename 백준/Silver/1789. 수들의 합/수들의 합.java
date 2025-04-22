import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 자연수 S 입력받기
        long s = Long.parseLong(br.readLine());

        // n 계산
        long n = 0;
        long sum = 0;
        while (sum < s) {
            sum += ++n;
        }

        // 만일 합한 값이 s를 초과했다면 n 카운트 하나 제거
        // (기존에 더했던 값들 중 하나를 빼는 것)
        if (sum > s) {
            n--;
        }

        bw.write("" + n);
        bw.flush();
        bw.close();
    }
}