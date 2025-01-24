import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        // N 입력받기
        int n = Integer.parseInt(br.readLine());

        // 두 자릿수 이하면 각 자리가 등차수열을 이룰 수 밖에 없음
        if (n < 100) {
            answer = n;
        }
        // 세 자리 이상이라면 계산
        else {
            for (int i = n; i > 100; i--) {
                int num100 = i / 100;
                int num10 = i % 100 / 10;
                int num1 = i % 100 % 10;

                // 각 자릿수의 차이가 일정하다면
                if (num1 - num10 == num10 - num100) {
                    answer++;
                }
            }

            // 두 자릿수 이하의 한수들 더하기
            answer += 99;
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}