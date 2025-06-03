import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력받기
        final int N = Integer.parseInt(br.readLine());
        
        // 돌이 홀수일 경우 상근이 승리
        // 짝수일 경우 창영이 승리
        if (N % 2 != 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}