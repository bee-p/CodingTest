import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수 입력받기
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int inputLength = input.length();
            int result = 0;
            int score = 0;

            for (int i = 0; i < inputLength; i++) {
                char now = input.charAt(i);

                if (now == 'O') {
                    score++;
                    result += score;
                } else {
                    score = 0;
                }
            }

            System.out.println(result);
        }
    }
}