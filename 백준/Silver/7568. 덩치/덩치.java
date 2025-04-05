import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력받기
        int n = Integer.parseInt(br.readLine());

        // 사람의 몸무게와 키 입력받기
        Pair[] persons = new Pair[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            persons[i] = new Pair(x, y);
        }

        // 덩치 등수 구하기
        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int k = 0; k < n; k++) {
                if (persons[i].x < persons[k].x && persons[i].y < persons[k].y) {
                    rank++;
                }
            }

            bw.write(rank + " ");
        }


        bw.flush();
        bw.close();
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}