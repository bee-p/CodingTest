import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 기본적으로 5의 개수당 0이 하나씩 증가
        // 그러나 5의 n승일 때는 그만큼 5가 n - 1개씩 더 있는 것이므로
        // 해당 수를 추가로 카운트해서 더함
        // 문제에서 제시한 n의 범위는 500이하이므로 625는 체크하지X
        int result = n / 5;
        result += n / 25;
        result += n / 125;

        System.out.println(result);
    }
}