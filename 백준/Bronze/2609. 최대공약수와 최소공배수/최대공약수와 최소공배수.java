import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 입력받기
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        // 계산
        int commonDivisor = 1;  // 공약수
        int commonMultiple = 1; // 공배수

        int min = Math.min(a, b);

        // 최대공약수 찾기
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
                commonDivisor *= i;

                i = 1;
                min = Math.min(a, b);
            }
        }

        // 최소공배수 계산 + 결과 출력
        commonMultiple = commonDivisor * a * b;

        System.out.println(commonDivisor);
        System.out.println(commonMultiple);
    }
}