class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int nowW = 0;
            int nowH = 0;
            
            // 가로가 더 크도록 돌림
            if (sizes[i][0] < sizes[i][1]) {
                nowW = sizes[i][1];
                nowH = sizes[i][0];
            } else {
                nowW = sizes[i][0];
                nowH = sizes[i][1];
            }
            
            // 최대 크기 계산
            if (maxW < nowW) {
                maxW = nowW;
            }
            if (maxH < nowH) {
                maxH = nowH;
            }
        }
        
        return maxW * maxH;
    }
}