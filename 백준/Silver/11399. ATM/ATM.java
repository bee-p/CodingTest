import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        // N, Pi 입력받기
        int n;
        n = sc.nextInt();

        ArrayList<Integer> pList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pList.add(sc.nextInt());
        }

        // 오름차순 정렬
        pList.sort(Comparator.naturalOrder());

        // 결과 구하기
        for (int i = 0; i < n; i++) {
            answer += pList.get(i) * (n - i);
        }

        System.out.println(answer);
    }
}