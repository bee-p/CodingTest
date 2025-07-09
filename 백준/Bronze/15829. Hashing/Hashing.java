import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 값 입력받기
        int size = Integer.parseInt(br.readLine());
        String input = br.readLine();

        // 해시 값 계산
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < size; i++) {
            BigInteger temp = BigInteger.ONE;
            for (int k = 0; k < i; k++) {
                temp = temp.multiply(BigInteger.valueOf(31));
            }
            result = result.add(temp.multiply(BigInteger.valueOf(input.charAt(i) - 'a' + 1)));
        }
        result = result.mod(BigInteger.valueOf(1234567891));

        // 결과 출력
        bw.write("" + result);
        bw.flush();
        bw.close();
    }
}