import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 세 변의 길이 입력받기
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 0 0 0 입력시 종료
            if (input[0] == 0) {
                break;
            }

            Arrays.sort(input);
            int sum1 = (int) (Math.pow(input[0], 2) + Math.pow(input[1], 2));
            int sum2 = (int) Math.pow(input[2], 2);

            if (sum1 == sum2) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}