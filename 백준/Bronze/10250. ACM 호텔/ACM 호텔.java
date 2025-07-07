import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력받기
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // H, W, N(몇 번째 손님) 입력받기
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            // 방 계산
            int floorNum =  n % h == 0 ? h : n % h;
            int orderNum = floorNum != h ? n / h + 1 : n / h;

            // 출력
            System.out.printf("%d%02d\n", floorNum, orderNum);
        }
    }
}