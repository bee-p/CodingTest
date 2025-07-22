import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int lastNum = 0;

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch (input) {
                case "push" -> {
                    int num = Integer.parseInt(st.nextToken());
                    queue.offer(num);

                    lastNum = num;
                }
                case "pop" -> {
                    if (!queue.isEmpty()) {
                        System.out.println(queue.poll());
                    } else {
                        System.out.println(-1);
                    }
                }
                case "size" -> {
                    System.out.println(queue.size());
                }
                case "empty" -> {
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                }
                case "front" -> {
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peek());
                    } else {
                        System.out.println(-1);
                    }
                }
                case "back" -> {
                    if (!queue.isEmpty()) {
                        System.out.println(lastNum);
                    } else {
                        System.out.println(-1);
                    }
                }
            }
        }
    }
}