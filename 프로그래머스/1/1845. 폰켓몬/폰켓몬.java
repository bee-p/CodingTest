import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        // 기존 사이즈 저장
        int size = nums.length;
        
        // 중복 제거
        nums = Arrays.stream(nums).distinct().toArray();
        

        return nums.length >= (size / 2) ? size / 2 : nums.length;
    }
}