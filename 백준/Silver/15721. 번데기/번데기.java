import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // A명, T번째, 구하고자 하는 구호 입력받기
        int a = sc.nextInt();
        int t = sc.nextInt();
        int target = sc.nextInt();

        // 몇회차, 몇번째 사람, 뻔/데기를 외친 횟수 표시
        int times = 1;  // n회차일 때 n+1씩 뻔, 데기를 반복해야 함
        int person = 0;
        int say = 0;

        // '뻔'을 구해야 할 경우
        if (target == 0) {
            A:
            while (true) {
                // 회차 증가
                times++;

                // 뻔 데기 뻔 데기
                for (int i = 0; i < 2; i++) {
                    // 뻔
                    person++;
                    say++;

                    if (say == t) {
                        break A;
                    }

                    // 데기
                    person++;
                }
                // 뻔 x times
                for (int i = 0; i < times; i++) {
                    person++;
                    say++;

                    if (say == t) {
                        break A;
                    }
                }
                // 데기 x times
                for (int i = 0; i < times; i++) {
                    person++;
                }
            }
        }
        // "데기"를 구해야 할 경우
        else if (target == 1) {
            A:
            while (true) {
                // 회차 증가
                times++;

                // 뻔 데기 뻔 데기
                for (int i = 0; i < 2; i++) {
                    // 뻔
                    person++;

                    // 데기
                    person++;
                    say++;

                    if (say == t) {
                        break A;
                    }
                }
                // 뻔 x times
                for (int i = 0; i < times; i++) {
                    person++;
                }
                // 데기 x times
                for (int i = 0; i < times; i++) {
                    person++;
                    say++;

                    if (say == t) {
                        break A;
                    }
                }
            }
        }

        // 해당 사람이 몇 번째에 앉은 사람인지 구해서 출력
        // 이때 K번째에서 K는 (0 <= K < A)
        System.out.println((person - 1) % a);
    }
}