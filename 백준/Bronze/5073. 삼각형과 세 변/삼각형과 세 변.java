import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] lengthList = new Integer[3];
        Set<Integer> set = new HashSet<>();

        while (true) {
            String inputStr = br.readLine();
            if (inputStr.equals("0 0 0")) {
                break;
            }

            String[] temp = inputStr.split(" ");
            for (int i = 0; i < 3; i++) {
                lengthList[i] = Integer.parseInt(temp[i]);
            }

            // 삼각형 조건 체크
            Arrays.sort(lengthList, Comparator.reverseOrder());
            if (lengthList[0] >= lengthList[1] + lengthList[2]) {
                System.out.println("Invalid");
                continue;
            }

            // 세 변의 길이 조건 체크
            for (int i = 0; i < 3; i++) {
                set.add(lengthList[i]);
            }
            switch (set.size()) {
                case 1 -> {
                    System.out.println("Equilateral");
                }
                case 2 -> {
                    System.out.println("Isosceles");
                }
                case 3 -> {
                    System.out.println("Scalene");
                }
            }

            set.clear();
        }
    }
}