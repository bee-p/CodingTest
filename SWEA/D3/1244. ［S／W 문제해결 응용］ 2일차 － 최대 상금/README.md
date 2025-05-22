# [D3] [S/W 문제해결 응용] 2일차 - 최대 상금 - 1244 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD) 

### 성능 요약

메모리: 32,684 KB, 시간: 106 ms, 코드길이: 2,021 Bytes

### 제출 일자

2025-05-22 22:45

### 접근 방법
- (처음에는 좌/우를 반씩 나누어 왼쪽에서는 제일 작은 숫자, 오른쪽에서는 제일 큰 숫자를 뽑아 둘이 교환하는 방식으로 코드를 구성했었는데, 이러한 방식으로 하니 놓치는 경우의 수가 발생해 방식을 바꾸었다.)
- 그래서 백트래킹 방식으로 처음부터 차례차례 숫자를 교환해가며 풀이했고, 같은 depth에서 같은 숫자판 형식이 또 나왔을 경우 해당 경로는 아예 진행하지 않도록 가지치기 하는 방식으로 구현했다.

> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do
