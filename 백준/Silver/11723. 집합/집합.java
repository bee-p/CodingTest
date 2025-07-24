import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String inputStr;
        int num;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            inputStr = st.nextToken();

            if (inputStr.equals("all")) {
                for (int k = 1; k <= 20; k++) {
                    set.add(k);
                }
                continue;
            } else if (inputStr.equals("empty")) {
                set.clear();
                continue;
            }

            num = Integer.parseInt(st.nextToken());

            switch (inputStr) {
                case "add" -> set.add(num);
                case "remove" -> set.remove(num);
                case "check" -> {
                    if (set.contains(num)) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                }
                case "toggle" -> {
                    if (!set.remove(num)) {
                        set.add(num);
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }
}