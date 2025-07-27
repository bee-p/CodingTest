import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 행: 숫자 N
    // 열(0, 1): 각각 0와 1이 등장한 횟수
    static int[][] fibonacci = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 피보나치(0)에서 0이 한 번 출력됨을 표시
        fibonacci[0][0] = 1;
        // 피보나치(1)에서 1이 한 번 출력
        fibonacci[1][1] = 1;

        // fibonacci(40)을 미리 수행
        doFibonacci(40);

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(fibonacci[n][0]).append(" ").append(fibonacci[n][1]).append("\n");
        }

        System.out.println(sb);
    }

    static void doFibonacci(int num) {
        if (fibonacci[num][0] == 0 && fibonacci[num][1] == 0) {
            doFibonacci(num - 1);
            doFibonacci(num - 2);

            fibonacci[num][0] = fibonacci[num - 1][0] + fibonacci[num - 2][0];
            fibonacci[num][1] = fibonacci[num - 1][1] + fibonacci[num - 2][1];
        }
    }
}