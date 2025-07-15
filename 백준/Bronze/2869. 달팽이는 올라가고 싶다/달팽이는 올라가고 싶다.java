import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값 받기
        String[] input = br.readLine().split(" ");
        int up = Integer.parseInt(input[0]);
        int down = Integer.parseInt(input[1]);
        int dst = Integer.parseInt(input[2]) - up;

        int result = dst % (up - down) == 0 ? dst / (up - down) + 1 : dst / (up - down) + 2;

        System.out.println(result);
    }
}