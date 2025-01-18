import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, K 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 동전의 가치 입력받기
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // 필요한 동전 개수의 최솟값 구하기
        int answer = 0;
        int coinNum = n - 1;
        while (k != 0) {
            if (k - coins[coinNum] >= 0) {
                k -= coins[coinNum];
                answer++;
            } else {
                coinNum--;
            }
        }

        System.out.println(answer);
    }
}