import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // n개 중 k개를 순서 없이 고르는 조합의 수 구하기
        int result = factorial(n) / (factorial(k) * factorial(n - k));

        System.out.println(result);
    }

    static int factorial(int num) {
        int result = 1;

        for (int i = num; i > 1; i--) {
            result *= i;
        }

        return result;
    }
}