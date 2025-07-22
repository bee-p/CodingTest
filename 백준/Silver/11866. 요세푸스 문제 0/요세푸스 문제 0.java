import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // 숫자 채우기
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        // 순열 출력
        int index = -1;
        int count = 0;
        StringBuilder output = new StringBuilder("<");

        while (true) {
            if (arr.isEmpty()) {
                break;
            }

            if (count == k) {
                index %= arr.size();
                output.append(arr.get(index)).append(", ");
                arr.remove(index);

                index--;
                count = 0;
            } else {
                count++;
                index++;
            }
        }

        // 마지막 ", " 제거 후 괄호 닫기
        output.delete(output.length() - 2, output.length()).append(">");

        System.out.println(output);
    }
}