import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length;
        
        // 중복 제거
        nums = Arrays.stream(nums).distinct().toArray();
        
        if (nums.length >= size / 2) {
            answer = size / 2;
        } else {
            answer = nums.length;
        }

        return answer;
    }
}