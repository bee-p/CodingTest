import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] an1 = {1, 2, 3, 4, 5};
        int[] an2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] an3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] corrects = new int[3];
        
        // 정답 검증
        for (int i = 0; i < answers.length; i++) {
            // 1번 수포자
            int tempAn = an1[i % an1.length];
            if (answers[i] == tempAn) {
                corrects[0]++;
            }
            
            // 2번 수포자
            tempAn = an2[i % an2.length];
            if (answers[i] == tempAn) {
                corrects[1]++;
            }
            
            // 3번 수포자
            tempAn = an3[i % an3.length];
            if (answers[i] == tempAn) {
                corrects[2]++;
            }
        }
        
        // 순위 도출
        ArrayList<Integer> people = new ArrayList<>();
        int maxCorrect = 0;
        
        for (int i = 0; i < corrects.length; i++) {
            if (maxCorrect < corrects[i]) {
                maxCorrect = corrects[i];
                people.clear();
                people.add(i + 1);
            }
            else if (maxCorrect == corrects[i]) {
                people.add(i + 1);
            }
        }
        
        int[] answer = people.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        return answer;
    }
}