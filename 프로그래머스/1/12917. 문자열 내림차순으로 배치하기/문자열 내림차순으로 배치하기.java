import java.util.Arrays;


class Solution {
    public String solution(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        
        // 내림차순(역순)으로 적재
        StringBuilder answer = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            answer.append(str[i]);
        }
        
        return answer.toString();
    }
}