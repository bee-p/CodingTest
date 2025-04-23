import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 수 N 입력받기
        int n = Integer.parseInt(br.readLine());

        // 사용할 스택 세팅
        int[] stack = new int[n];
        int index = -1;

        // 명령 수행
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            switch (name) {
                case "push" -> {
                    int num = Integer.parseInt(st.nextToken());
                    stack[++index] = num;
                }
                case "pop" -> {
                    if (index == -1) {
                        bw.write("-1\n");
                    } else {
                        bw.write("" + stack[index--] + "\n");
                    }
                }
                case "size" -> {
                    bw.write("" + (index + 1) + "\n");
                }
                case "empty" -> {
                    if (index == -1) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                }
                case "top" -> {
                    if (index == -1) {
                        bw.write("-1\n");
                    } else {
                        bw.write("" + stack[index] + "\n");
                    }
                }
                default -> {
                    bw.flush();
                }
            }
        }

        bw.close();
    }
}