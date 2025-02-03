import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 데이터 입력받기
        int n = sc.nextInt();
        int maxFive = n / 5; // 5kg 봉지를 최대한 많이 사용하도록 함

        while (maxFive >= 0) {
            // 남은 무게가 3kg으로 나누어떨어지는지 확인
            int remaining = n - (maxFive * 5);
            // 정확하게 다 사용했다면 결과 출력
            if (remaining % 3 == 0){
                int count = maxFive + (remaining / 3);
                System.out.println(count);
                return;
            }
            // 5kg 봉지 개수를 줄여가며 탐색
            maxFive--;
        }

        System.out.println(-1); // 정확히 나눌 수 없는 경우
    }
}