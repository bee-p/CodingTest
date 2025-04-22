import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수 입력받기
        int t = Integer.parseInt(br.readLine());

        // 테스트 케이스만큼 계산
        for (int n = 0; n < t; n++) {
            // 거스름돈 입력받기
            int money = Integer.parseInt(br.readLine());

            // 각 동전의 개수
            int qCount = 0;
            int dCount = 0;
            int nCount = 0;
            int pCount = 0;

            // 거스름돈 계산
            qCount = money / 25;
            money -= qCount * 25;

            dCount = money / 10;
            money -= dCount * 10;

            nCount = money / 5;
            money -= nCount * 5;

            pCount = money;

            System.out.printf("%d %d %d %d\n", qCount, dCount, nCount, pCount);
        }
    }
}