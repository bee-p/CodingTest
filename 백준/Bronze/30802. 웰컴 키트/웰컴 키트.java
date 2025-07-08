import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 입력받기
        int n = Integer.parseInt(br.readLine());
        int[] sizeList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bundles = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 티셔츠 계산
        int shirts = 0;
        for (int i = 0; i < sizeList.length; i++) {
            shirts += sizeList[i] % bundles[0] != 0 ?
                    sizeList[i] / bundles[0] + 1 : sizeList[i] / bundles[0];
        }

        // 펜 계산
        int penBundle = n / bundles[1];
        int penOne = n % bundles[1];

        // 결과 출력
        System.out.println(shirts);
        System.out.println(penBundle + " " + penOne);
    }
}