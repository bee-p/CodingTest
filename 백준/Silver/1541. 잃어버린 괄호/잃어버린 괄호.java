import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        // 식 입력 받기
        String exp = sc.nextLine();

        // 연산자 리스트
        ArrayList<String> oprArr = new ArrayList(Arrays.asList(exp.split("[0-9]+")));
        if (oprArr.size() != 0) {
            oprArr.remove(0);
        }

        // 만일 '-' 또는 '+'로만 구성되어 있다면
        if (oprArr.stream().distinct().count() == 1) {
            // 숫자(피연산자) 리스트
            ArrayList<Integer> numArr = new ArrayList(
                    Arrays.stream(exp.split("-|\\+")).map(Integer::parseInt).collect(Collectors.toList()));

            // 첫 번째 값 저장
            answer = numArr.get(0);

            // 차례대로 연산 수행
            if (oprArr.get(0).equals("-")) {
                for (int i = 1; i < numArr.size(); i++) {
                    answer -= numArr.get(i);
                }
            } else {
                for (int i = 1; i < numArr.size(); i++) {
                    answer += numArr.get(i);
                }
            }
        }
        // '-'와 '+'가 혼합되어 있을 경우
        else {
            // 1. '-' 기준으로 분리하기
            ArrayList<String> minusSplit = new ArrayList(Arrays.asList(exp.split("-")));

            // 2. 첫 번째 뭉치에서 '+' 기준으로 분리하고 값 더해서 저장
            ArrayList<Integer> firstList = new ArrayList(
                    Arrays.stream(minusSplit.get(0).split("\\+")).map(Integer::parseInt).collect(Collectors.toList()));
            for (int num : firstList) {
                answer += num;
            }

            // 3-1. 각 뭉치에서 '+' 기준으로 분리하기
            for (int i = 1; i < minusSplit.size(); i++) {
                ArrayList<Integer> plusList = new ArrayList(
                        Arrays.stream(minusSplit.get(i).split("\\+")).map(Integer::parseInt).collect(Collectors.toList()));

                // 3-2. 분리한 값을 한 번에 더한 후 결과값에서 빼기
                int sum = 0;
                for (int num : plusList) {
                    sum += num;
                }
                answer -= sum;
            }
        }

        System.out.println(answer);
    }
}