import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 값 입력받기
        int size = Integer.parseInt(br.readLine());
        String input = br.readLine();

        // 해시 값 계산
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += (input.charAt(i) - 'a' + 1) * Math.pow(31, i);
        }
        result %= 1234567891;

        // 결과 출력
        bw.write("" + result);
        bw.flush();
        bw.close();
    }
}