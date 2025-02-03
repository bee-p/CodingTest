import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 데이터 입력 받기
        int n = sc.nextInt();

        int count = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                n -= 5;
            } else if (n % 3 == 0) {
                n -= 3;
            } else if (n >= 5) {
                n -= 5;
            } else {
                n -= 3;
            }
            count++;
        }

        // 결과 출력
        if (n == 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}