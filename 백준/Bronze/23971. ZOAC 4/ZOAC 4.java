import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 받기
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]) - 1;
        int w = Integer.parseInt(input[1]) - 1;
        int n = Integer.parseInt(input[2]) + 1;
        int m = Integer.parseInt(input[3]) + 1;

        // 세로 앉은 수 * 가로 앉은 수로 결과 구해서 출력
        bw.write ("" + (1 + h / n) * (1 + w / m));

        bw.flush();
        bw.close();
    }
}