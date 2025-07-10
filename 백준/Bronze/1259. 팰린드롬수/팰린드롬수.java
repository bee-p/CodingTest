import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();

            if (input.equals("0")) {
                break;
            }

            int size = input.length();
            boolean isPalindrome = true;
            for (int i = 0; i < size / 2; i++) {
                int j = size - 1 - i;

                if (input.charAt(i) != input.charAt(j)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}