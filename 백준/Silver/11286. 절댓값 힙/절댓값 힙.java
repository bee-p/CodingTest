import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 절댓값으로 오름차순 정렬
        PriorityQueue<Integer> queue = new PriorityQueue((o1, o2) -> {
            int n1 = (int) o1;
            int n2 = (int) o2;

            // 절댓값이 같을 경우, 더 작은 숫자를 우선
            if (Math.abs(n1) == Math.abs(n2)) {
                return n1 - n2;
            } else {
                return Math.abs(n1) - Math.abs(n2);
            }
        });
        StringBuffer output = new StringBuffer();

        for (int tc = 0; tc < n; tc++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                queue.offer(num);
            } else {
                if (!queue.isEmpty()) {
                    output.append(queue.poll()).append('\n');
                } else {
                    output.append('0').append('\n');
                }
            }
        }

        System.out.println(output);
    }
}

