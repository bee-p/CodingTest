import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[] input = br.readLine().toCharArray();

            int count = 0;
            boolean isCorrect = true;

            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(') {
                    count++;
                } else {
                    count--;

                    if (count < 0) {
                        isCorrect = false;
                        break;
                    }
                }
            }

            if (isCorrect && count == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}