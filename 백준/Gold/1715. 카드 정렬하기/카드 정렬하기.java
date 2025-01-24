import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 줄의 수 입력받기
        int n = Integer.parseInt(br.readLine());
        // 숫자 카드 입력받기
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(br.readLine()));
        }

        // 답 구하기
        int answer = 0;
        while (q.size() > 1) {
            int first = q.poll();
            int second = q.poll();

            answer += first + second;

            q.offer(first + second);
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}