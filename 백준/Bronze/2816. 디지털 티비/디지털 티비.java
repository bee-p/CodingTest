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

        // 채널들 입력받기
        String[] tvList = new String[n];
        for (int i = 0; i < n; i++) {
            tvList[i] = br.readLine();
        }

        // 탐색
        // 인덱스 0부터 탐색하면서, KBS1이나 KBS2을 처음 발견했다면 그 위치까지 1번 동작, 4번 동작 수행
        // 이후 남은 채널에 대해서는 어떤 채널이냐에 따라 맞춤 동작 수행
        String result = "";
        boolean isSwitch = false;  // 하나라도 채널을 위쪽에 올렸다면 true
        for (int i = 0; i < n; i++) {
            // KBS1, KBS2 둘 중 하나라도 발견했다면
            if (tvList[i].equals("KBS1") || tvList[i].equals("KBS2")) {
                String buttons = "1".repeat(i) + "4".repeat(i);

                if (!isSwitch) {
                    result += buttons;
                    isSwitch = true;
                } else {
                    // 남은 (지금 위쪽으로 올려야 하는) 채널이 KBS1이라면
                    if (tvList[i].equals("KBS1")) {
                        result += buttons;
                    }
                    // KBS2라면
                    else {
                        result += "1".repeat(i) + "4".repeat(i - 1);
                        break;
                    }
                }
            }
        }

        // 결과 출력
        bw.write(result);
        bw.flush();
        bw.close();
    }
}