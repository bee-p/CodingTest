import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력받기
        int n = Integer.parseInt(br.readLine());

        // N줄
        for (int k = 1; k <= n; k++) {
            // 공백 찍기
            System.out.print(" ".repeat(n - k));
            // 별 찍기
            System.out.print("*".repeat(k) + "\n");
        }
    }
}