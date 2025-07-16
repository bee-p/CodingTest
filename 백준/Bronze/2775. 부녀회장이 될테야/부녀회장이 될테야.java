import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0층 사전 세팅
        for (int i = 1; i <= 14; i++) {
            map[0][i] = i;
        }
        // 전층 1호 사전 세팅
        for (int i = 1; i <= 14; i++) {
            map[i][1] = 1;
        }

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int floor = Integer.parseInt(br.readLine());
            int roomNum = Integer.parseInt(br.readLine());

            Room left = new Room(floor, roomNum - 1);
            Room down = new Room(floor - 1, roomNum);

            search(left, down);

            System.out.println(map[floor][roomNum]);
        }
    }

    static void search(Room left, Room down) {
        int nowFloor = left.floor;
        int nowRoomNum = down.roomNum;

        if (nowFloor == 0 || nowRoomNum == 1) {
            return;
        }

        if (map[left.floor][left.roomNum] == 0) {
            left.roomNum--;
            down.roomNum--;
            search(left, down);

            left.roomNum++;
            down.roomNum++;
        }

        if (map[down.floor][down.roomNum] == 0) {
            int tempFloor = left.floor;
            int tempRoomNum = left.roomNum;

            left.floor = down.floor;
            left.roomNum = down.roomNum - 1;
            down.floor--;
            search(left, down);

            left.floor = tempFloor;
            left.roomNum = tempRoomNum;
            down.floor++;
        }

        map[nowFloor][nowRoomNum] = map[left.floor][left.roomNum] + map[down.floor][down.roomNum];
    }
}

class Room {
    int floor;
    int roomNum;

    Room(int floor, int roomNum) {
        this.floor = floor;
        this.roomNum = roomNum;
    }
}