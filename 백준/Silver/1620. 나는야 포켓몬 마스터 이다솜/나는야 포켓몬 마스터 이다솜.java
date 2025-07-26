import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] pokemonList = new String[n + 1];
        Map<String, Integer> nameToNumList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            pokemonList[i] = name;
            nameToNumList.put(name, i);
        }

        int num;
        String input;
        for (int i = 0; i < m; i++) {
            input = br.readLine();

            try {
                num = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                bw.write(nameToNumList.get(input) + "\n");
                continue;
            }

            bw.write(pokemonList[num] + "\n");
        }
        bw.flush();
        bw.close();
    }
}