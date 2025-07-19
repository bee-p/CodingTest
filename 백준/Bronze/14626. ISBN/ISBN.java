import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");

        int sum = 0;
        int foundIndex = -1;

        // 짝수 (1 곱함)
        for (int i = 0; i < input.length; i += 2) {
            if (!input[i].equals("*")) {
                sum += Integer.parseInt(input[i]);
            } else {
                foundIndex = i;
            }
        }

        // 홀수 (3 곱함)
        for (int i = 1; i < input.length; i += 2) {
            if (!input[i].equals("*")) {
                sum += Integer.parseInt(input[i]) * 3;
            } else {
                foundIndex = i;
            }
        }

        // 결과 계산
        if (sum % 10 == 0) {
            System.out.println(0);
        } else if (foundIndex % 2 == 0) {
            System.out.println(10 - (sum % 10));
        } else {
            for (int i = 1; i < 10; i++) {
                if ((sum + i * 3) % 10 == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}