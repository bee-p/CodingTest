import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 회의의 수 입력받기
        int n = Integer.parseInt(br.readLine());
        // 회의 정보 입력받기
        ArrayList<Pair> time = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] splitStr = str.split(" ");
            time.add(new Pair(Integer.parseInt(splitStr[0]), Integer.parseInt(splitStr[1])));
        }

        // 정렬
        Collections.sort(time, (p1, p2) -> {
            // 만약 둘의 끝나는 시각이 같다면
            if (p1.end == p2.end) {
                // 더 짧은 시작 순으로 정렬
                return p1.start - p2.start;
            }
            else {
                // 그게 아니면 끝나는 시각이 빠른 순서로 정렬 (오름차순)
                return p1.end - p2.end;
            }
        });

        // 사용할 수 있는 회의의 최대 개수 구하기
        int answer = 0;
        int endTime = 0;
        for (int i = 0; i < n; i++) {
            if (time.get(i).start >= endTime) {
                endTime = time.get(i).end;
                answer++;
            }
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}