# [Gold V] 회의실 배정 - 1931 

[문제 링크](https://www.acmicpc.net/problem/1931) 

### 성능 요약

메모리: 54612 KB, 시간: 592 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2025년 1월 24일 21:16:53

### 문제 설명

<p>한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.</p>

### 입력 

 <p>첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 2<sup>31</sup>-1보다 작거나 같은 자연수 또는 0이다.</p>

### 출력 

 <p>첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.</p>

***

### 접근 방법
- 우선 시작 시각과 끝나는 시각이 주어지므로 Pair 클래스를 구현하여 풀이했다.
- 처음에는 두 개의 기준에 맞추어 정렬했다.
  1. 시간 간격이 짧은 순으로
  2. 시간 간격이 똑같다면 시작하는 시각이 짧은 순으로
  - 근데 이렇게 하니 시간을 끼워넣는 과정이 애매해질 것 같았다.....
  - 왜냐하면 시작하는 시각도, 끝나는 시각도 뒤죽박죽이라 처음부터 차곡차곡 시간을 끼워넣을 수 없을 것 같았기 때문이다.
- 그래서 다른 기준을 세워 정렬했다.
  1. 끝나는 시각이 빠른 순서로 (오름차순)
  2. 끝나는 시각이 같다면, 시작하는 시각이 빠른 순서로(오름차순) 정렬했다. (보통 회의 시간이 빠른 사람이 선점하니까..)
  - 이후에는 정렬된 리스트의 원소를 하나씩 돌면서 회의의 시작 시각이 현재 끝나는 시각과 같거나 더 이후에 있으면 그 회의를 선택하고(answer 카운팅), 끝나는 시각을 선택한 회의의 끝나는 시각으로 업데이트하는 방식으로 풀었다.
