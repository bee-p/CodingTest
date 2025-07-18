import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = new String[3];
        int numPos = -1;
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();

            try {
                Integer.parseInt(arr[i]);
            } catch (java.lang.NumberFormatException e) {
                continue;
            }

            numPos = i;
        }

        int resultNum = Integer.parseInt(arr[numPos]);
        switch (numPos) {
            case 0 -> {
                resultNum += 3;
            }
            case 1 -> {
                resultNum += 2;
            }
            case 2 -> {
                resultNum += 1;
            }
        }

        System.out.println(fizzbuzz(resultNum));
    }

    static String fizzbuzz(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }
    }
}