import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        String result = "";
        if (num == 1) {
            result = "ascending";
        } else if (num == 8) {
            result = "descending";
        } else {
            System.out.println("mixed");
            return;
        }

        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());

            // 연속한 두 숫자의 차이가 1이 아니라면 섞인 것
            if (Math.abs(num - input) != 1) {
                System.out.println("mixed");
                return;
            }

            // 그게 아니라면 계속 검사
            num = input;
        }

        // 검사에 통과한 경우 결과 출력
        System.out.println(result);
    }
}