import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] sortedArr = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArr[i] = Integer.parseInt(br.readLine());
        }
        int[] inputArr = sortedArr.clone();
        Arrays.sort(sortedArr);

        int i = 0;
        int targetIndex = 0;
        boolean isYes = true;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (targetIndex < n) {
            // 해당 숫자가 맨 위에 있다면 pop
            if (!stack.isEmpty() && stack.peek() == inputArr[targetIndex]) {
                stack.pop();
                sb.append("-\n");
                targetIndex++;
                continue;
            }

            // 해당 숫자까지 스택에 넣기
            while (true) {
                stack.push(sortedArr[i]);
                sb.append("+\n");

                if (sortedArr[i] == inputArr[targetIndex]) {
                    stack.pop();
                    sb.append("-\n");
                    targetIndex++;
                    i++;
                    break;
                }

                i++;
            }

            // 만약 다음 타겟 숫자가 나올 수 없는 구조라면
            if (!stack.isEmpty() && inputArr[targetIndex] < stack.peek()) {
                isYes = false;
                break;
            }
        }

        if (isYes) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}