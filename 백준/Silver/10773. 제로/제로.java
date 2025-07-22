import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int[] stack = new int[k];
        int pos = -1;

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());

            // 숫자 추가
            if (num != 0) {
                stack[++pos] = num;
            }
            // 삭제
            else {
                stack[pos--] = 0;
            }
        }

        // 숫자 합산
        int result = 0;
        for (int i = 0; i < k; i++) {
            if (stack[i] == 0) {
                break;
            }

            result += stack[i];
        }
        System.out.println(result);
    }
}