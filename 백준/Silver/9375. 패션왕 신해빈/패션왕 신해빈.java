import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> clothes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                if (clothes.containsKey(type)) {
                    clothes.replace(type, clothes.get(type) + 1);
                } else {
                    clothes.put(type, 1);
                }
            }

            int result = 1;
            for (Integer count : clothes.values()) {
                // 한 종류에서 아무것도 선택하지 않는 경우의 수도 있으므로 +1을 함
                result *= (count + 1);
            }

            // 모든 종류에서 전부 선택하지 않는 경우의 수는 빼야 하기에 -1을 함
            sb.append(result - 1).append("\n");
        }

        System.out.println(sb);
    }
}

