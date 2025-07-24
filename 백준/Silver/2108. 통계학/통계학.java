import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Map<Integer, Integer> numCount = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];

            // 빈도 수 카운트
            if (numCount.containsKey(arr[i])) {
                numCount.put(arr[i], numCount.get(arr[i]) + 1);
            } else {
                numCount.put(arr[i], 1);
            }
        }

        Arrays.sort(arr);

        // 최빈값 계산
        List<Integer> keyList = new ArrayList<>(numCount.keySet());
        keyList.sort(Integer::compareTo);
        int maxCount = 0;
        int maxNum = 4001;
        int secMaxCount = 0;
        int secMaxNum = 4001;
        for (int i = keyList.size() - 1; i >= 0; i--) {
            int key = keyList.get(i);

            if (maxCount <= numCount.get(key)) {
                if (maxCount != 0) {
                    secMaxNum = maxNum;
                    secMaxCount = maxCount;
                }
                maxNum = key;
                maxCount = numCount.get(key);
            }
        }

        // 결과 출력
        // 1. 산술평균
        System.out.println(Math.round((double) sum / n));
        // 2. 중앙값
        System.out.println(arr[n / 2]);
        // 3. 최빈값
        if (maxCount != secMaxCount) {
            System.out.println(maxNum);
        } else {
            System.out.println(secMaxNum);
        }
        // 4. 범위
        System.out.println(arr[n - 1] - arr[0]);
    }
}