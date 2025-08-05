import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dividePaper(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    // 색상을 체크해 동일 여부를 반환하는 메소드
    // true: 해당 범위의 색상이 모두 같을 경우
    // false: 해당 범위 내 색상이 서로 다를 경우
    static boolean checkColor(int x, int y, int length) {
        int color = paper[x][y];
        int xLength = x + length;
        int yLength = y + length;

        for (int i = x; i < xLength; i++) {
            for (int j = y; j < yLength; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }

    // 종이를 나누고 색종이 개수를 세는 메소드
    static void dividePaper(int x, int y, int length) {
        // 해당 범위의 색상이 모두 같다면
        if (checkColor(x, y, length)) {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        // 아니라면 4장으로 분리
        int newLength = length / 2;

        dividePaper(x, y, newLength);                                 // 2사분면
        dividePaper(x + newLength, y, newLength);                  // 1사분면
        dividePaper(x, y + newLength, newLength);                  // 3사분면
        dividePaper(x + newLength, y + newLength, newLength);   // 4사분면
    }
}