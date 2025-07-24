import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list.clear();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.valueOf(st.nextToken()));
            }

            // 시뮬레이션
            int order = 0;
            while (true) {
                if (list.size() == 1) {
                    order++;
                    break;
                }

                // 뒷 순서에 중요도가 낮은 문서가 있는지 검사
                int now = list.remove(0);
                m--;

                int listSize = list.size();
                boolean isRemoved = true;
                for (int i = 0; i < listSize; i++) {
                    // 뒤에 중요도가 낮은 문서가 있을 경우 해당 문서 뒤로 보냄
                    if (now < list.get(i)) {
                        if (m == -1) {
                            m = listSize;
                        }

                        list.add(now);
                        isRemoved = false;
                        break;
                    }
                }

                // 인쇄 되었다면 출력 순서 증가
                if (isRemoved) {
                    order++;

                    // 근데 그게 궁금한 문서였을 경우 종료
                    if (m == -1) {
                        break;
                    }
                }
            }

            System.out.println(order);
        }
    }
}