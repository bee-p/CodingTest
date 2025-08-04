import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder output = new StringBuilder();
        for (int t = 0; t < n; t++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (queue.isEmpty()) {
                    output.append("0\n");
                } else {
                    output.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(input);
            }
        }
        System.out.println(output);
    }
}