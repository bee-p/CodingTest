import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    static int count;  // 교환 횟수
    static int max;    // 가장 큰 금액 (결과 값)
    static HashSet<String>[] visited;    // 방문 정보 set

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수 입력받기
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            // 1. 숫자판 정보와 교환 횟수 입력받기
            String[] input = br.readLine().split(" ");
            char[] str = input[0].toCharArray();
            count = Integer.parseInt(input[1]);

            // 2. 정보 값 초기화
            max = 0;
            visited = new HashSet[count + 1];
            for (int k = 0; k <= count; k++) {
                visited[k] = new HashSet<>();
            }

            // 3. 계산
            backtrack(str, 0);

            // 4. 결과 값 출력
            System.out.printf("#%d %d\n", i, max);
        }
    }

    static void backtrack(char[] arr, int depth) {
        // 교환횟수를 다 소진했다면 종료
        if (depth == count) {
            max = Math.max(max, Integer.parseInt(new String(arr)));
            return;
        }

        // 현재 숫자판 방문 표시
        // 이미 해당 depth에서 나온 숫자판이라면 더이상 진행X
        String now = new String(arr);
        if (visited[depth].contains(now)) {
            return;
        }
        visited[depth].add(now);

        // 자릿수 교환 탐색
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(arr, i, j);
                backtrack(arr, depth + 1);
                swap(arr, i, j);    // 원상태로 되돌리기
            }
        }
    }

    static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}