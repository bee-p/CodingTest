import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 회원 수 입력받기
        int n = Integer.parseInt(br.readLine());

        // 회원 정보 입력받기
        Pair[] info = new Pair[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            info[i] = new Pair(Integer.parseInt(input[0]), input[1]);
        }

        // 정렬
        Arrays.sort(info, Comparator.comparingInt(o -> o.age));

        // 출력
        for (int i = 0; i < n; i++) {
            bw.write(info[i].age + " " + info[i].name + '\n');
        }
        bw.flush();
        bw.close();
    }
}

class Pair {
    int age;
    String name;

    Pair(int age, String name) {
        this.age = age;
        this.name = name;
    }
}