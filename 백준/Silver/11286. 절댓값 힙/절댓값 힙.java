import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Heap heap = new Heap(n);
        StringBuilder output = new StringBuilder();

        for (int tc = 0; tc < n; tc++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                heap.add(num);
            } else {
                output.append(heap.pop()).append('\n');
            }
        }

        System.out.println(output);
    }
}

class Heap {
    int[] heap;
    int size;

    Heap(int n) {
        heap = new int[n + 1];
        size = 0;
    }

    // 두 값의 우선 순위를 계산하는 메소드
    // n1의 우선 순위가 더 높을 경우 -> true 반환
    // n2의 우선 순위가 더 높을 경우 -> false 반환
    boolean isSwap(int n1, int n2) {
        return Math.abs(n1) < Math.abs(n2) || (Math.abs(n1) == Math.abs(n2) && n1 < n2);
    }

    // 인덱스를 받아 heap 내의 값의 위치를 서로 바꾸는 메소드
    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // min heap 방식의 삽입 메소드
    void add(int num) {
        heap[++size] = num; // 마지막 부분에 요소 추가

        // 정렬
        for (int i = size; i > 1; i /= 2) {
            // 현재 노드의 절댓값이 자신의 부모 노드보다 작거나,
            // 둘의 절댓값이 같고 자신의 값이 부모 노드보다 작다면 교환
            if (isSwap(heap[i], heap[i / 2])) {
                swap(i, i / 2);
            } else {
                break;
            }
        }
    }

    // min heap 방식의 삭제 메소드
    int pop() {
        if (size != 0) {
            int output = heap[1];
            heap[1] = heap[size];   // 맨 마지막에 있는 요소 위로 올림
            heap[size--] = 0;

            int now = 1;
            while (true) {
                int lPos = now * 2;       // 왼쪽 자식 노드의 위치
                int rPos = now * 2 + 1;   // 오른쪽 자식 노드의 위치

                // 자식이 아예 없다면 종료
                if (lPos > size) {
                    break;
                }

                int nextPos = lPos;

                // 오른쪽 자식도 있다면
                if (rPos <= size) {
                    if (isSwap(heap[rPos], heap[lPos])) {
                        nextPos = rPos;
                    }
                }

                // 현재 노드와 선택된 자식 노드 비교
                if (isSwap(heap[now], heap[nextPos])) {
                    nextPos = now;
                }

                // 교환을 안 해도 되는 상태면 종료
                if (nextPos == now) {
                    break;
                }
                // 그게 아니라면 교환 진행
                else {
                    swap(now, nextPos);
                    now = nextPos;
                }
            }

            return output;
        } else {
            return 0;
        }
    }
}

