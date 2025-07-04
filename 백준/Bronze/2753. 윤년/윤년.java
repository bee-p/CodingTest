import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연도 입력받기
        int year = Integer.parseInt(br.readLine());

        // 윤년일 때
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}