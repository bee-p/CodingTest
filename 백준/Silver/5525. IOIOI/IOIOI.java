import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int result = 0;
        int oCount = 0;
        for (int i = 1; i < M - 1; i++) {
            char now = S.charAt(i);
            char pre = S.charAt(i - 1);
            char next = S.charAt(i + 1);

            // 현재 문자를 기준으로 양쪽을 확인
            if (now == 'O' && pre == 'I' && next == 'I') {
                // O 개수 증가
                oCount++;

                // 만일 현재 구하려는 Pn이 다 나왔다면
                if (oCount == N) {
                    result++;
                    oCount--;
                }
            }
            // 만일 OIO 형태면 넘어감
            else if (now == 'I' && pre == 'O' && next == 'O') {
                // continue..
            }
            // 그 외의 경우는 Pn 문자열이 아니므로 O 개수 초기화
            else {
                oCount = 0;
            }
        }

        System.out.println(result);
    }
}