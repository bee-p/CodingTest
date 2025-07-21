import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            char[] input = br.readLine().toCharArray();

            // 종료 조건 체크
            if (input.length == 1 && input[0] == '.') {
                break;
            }

            // 소괄호가 들어가면 true
            // 대괄호가 들어가면 false 삽입
            Stack<Boolean> stack = new Stack<>();
            boolean isCorrect = true;

            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(') {
                    stack.add(true);
                } else if (input[i] == '[') {
                    stack.add(false);
                } else if (input[i] == ')') {
                    boolean pop;

                    try {
                        pop = stack.pop();
                    } catch (EmptyStackException e) {
                        isCorrect = false;
                        break;
                    }

                    // top에 있던 게 소괄호가 아니면 중단
                    if (!pop) {
                        isCorrect = false;
                        break;
                    }
                } else if (input[i] == ']') {
                    boolean pop;

                    try {
                        pop = stack.pop();
                    } catch (EmptyStackException e) {
                        isCorrect = false;
                        break;
                    }

                    // top에 있던 게 대괄호가 아니면 중단
                    if (pop) {
                        isCorrect = false;
                        break;
                    }
                }
            }

            // 판별
            if (stack.isEmpty() && isCorrect) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}