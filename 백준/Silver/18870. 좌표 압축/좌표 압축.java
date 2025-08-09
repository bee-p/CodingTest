import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer input = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] sortedArr = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArr[i] = arr[i] = Integer.parseInt(input.nextToken());
        }

        Arrays.sort(sortedArr);

        // 값이 적은 순서대로 0 ~ 인덱스 부여
        HashMap<Integer, Integer> posTable = new HashMap<>();

        // 맨 첫 번째 값 넣고 이후 인덱스 부여 시작
        int preNum = sortedArr[0];
        posTable.put(preNum, 0);
        int rank = 1;
        for (int i = 1; i < sortedArr.length; i++) {
            // 중복 값이 아닐 경우에만 입력
            if (preNum != sortedArr[i]) {
                preNum = sortedArr[i];
                posTable.put(sortedArr[i], rank);
                rank++;
            }
        }

        // 압축 좌표 출력
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            output.append(posTable.get(arr[i])).append(" ");
        }
        System.out.println(output);
    }
}