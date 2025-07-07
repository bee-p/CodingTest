import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 입력받기
        String input = br.readLine();
        int strLength = input.length();

        int[] result = new int[26];
        Arrays.fill(result, -1);

        for (int i = 0; i < strLength; i++) {
            int nowIndex = input.charAt(i) - 'a';

            if (result[nowIndex] == -1) {
                result[nowIndex] = i;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}