import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 상하좌우 이동 배열
        int[][] moveArr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // BFS 시작
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        
        while (!q.isEmpty()) {
            Pair now = q.poll();
            
            for (int[] move : moveArr) {
                int dx = now.x + move[0];
                int dy = now.y + move[1];
                
                if (0 <= dx && dx < n && 0 <= dy && dy < m
                        && maps[dx][dy] == 1) {
                    maps[dx][dy] = maps[now.x][now.y] + 1;
                    q.offer(new Pair(dx, dy));
                }
            }
        }
        
        return maps[n - 1][m - 1] != 1 ? maps[n - 1][m - 1] : -1;
    }
    
    class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}