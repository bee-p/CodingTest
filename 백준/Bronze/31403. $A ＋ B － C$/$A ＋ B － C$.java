import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A, B, C 입력받기
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        // 첫 줄 출력
        System.out.println(a + b - c);

        // 둘째 줄 출력
        System.out.println(Integer.parseInt(String.valueOf(a) + b) - c);
    }
}