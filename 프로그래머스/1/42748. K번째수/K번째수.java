import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] partialArr = 
                Arrays
                .stream(array, commands[i][0] - 1, commands[i][1])
                .sorted()
                .toArray();
            
            answer[i] = partialArr[commands[i][2] - 1];
        }
        
        return answer;
    }
}