import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력받기
        int n = Integer.parseInt(br.readLine());

        // 계산
        int count = 1;
        int turn = 1;
        int num = 1;
        boolean isFind = false;

        // 만일 N이 1일 경우
        if (n == 1) {
            isFind = true;
        }
        // 그 외의 경우 탐색 진행
        while (!isFind) {
            // 방 방문 횟수 증가
            count++;

            // n을 찾았다면 중지
            int max = num + (6 * turn);
            if (num + 1 <= n && n <= max) {
                break;
            }

            // 못 찾았다면 다음 턴으로 넘기기
            num = max;
            turn++;
        }

        // 결과 출력
        bw.write("" + count);
        bw.flush();
        bw.close();
    }
}