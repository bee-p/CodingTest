import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 지불해야할 돈 입력받기
        int pay = sc.nextInt();

        // 거스름돈
        int money = 1000 - pay;
        int count = 0;

        while (money > 0) {
            if (money >= 500) {
                money -= 500;
            } else if (money >= 100) {
                money -= 100;
            } else if (money >= 50) {
                money -= 50;
            } else if (money >= 10) {
                money -= 10;
            } else if (money >= 5) {
                money -= 5;
            } else {
                count += money - 1;
                money = 0;
            }

            count++;
        }

        System.out.println(count);
    }
}