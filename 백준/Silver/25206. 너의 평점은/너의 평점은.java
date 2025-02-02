import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 데이터 입력 받기
        double result = 0;
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            String[] str = br.readLine().split(" ");
//            String name = str[0];
            double credit = Double.parseDouble(str[1]);
            String grade = str[2];

            if (grade.equals("P")) {
                continue;
            }

            double score = gradeToScore(grade);

            // 계산 수행
            result += credit * score;
            sum += credit;
        }

        System.out.printf("%.6f", result / sum);
    }

    private static double gradeToScore(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0.0;
        }
    }
}