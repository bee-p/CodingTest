import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> nList = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nList.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (nList.contains(input)) {
                result.add(input);
            }
        }
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        int size = result.size();
        sb.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}

