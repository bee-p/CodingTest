# [Bronze III] ZOAC 4 - 23971 

[문제 링크](https://www.acmicpc.net/problem/23971) 

### 성능 요약

메모리: 14336 KB, 시간: 108 ms

### 분류

사칙연산, 수학

### 제출 일자

2025년 4월 5일 16:57:49

### 문제 설명

<p>2021년 12월, 네 번째로 개최된 ZOAC의 오프닝을 맡은 성우는 오프라인 대회를 대비하여 강의실을 예약하려고 한다.</p>

<p>강의실에서 대회를 치르려면 거리두기 수칙을 지켜야 한다!</p>

<p>한 명씩 앉을 수 있는 테이블이 행마다 <i>W</i>개씩 <em>H</em>행에 걸쳐 있을 때, 모든 참가자는 세로로 <i>N</i>칸 또는 가로로 <i>M</i>칸 이상 비우고 앉아야 한다. 즉, 다른 모든 참가자와 세로줄 번호의 차가 <i>N</i>보다 크거나 가로줄 번호의 차가 <i>M</i>보다 큰 곳에만 앉을 수 있다.</p>

<p>논문과 과제에 시달리는 성우를 위해 강의실이 거리두기 수칙을 지키면서 최대 몇 명을 수용할 수 있는지 구해보자.</p>

### 입력 

 <p><i>H</i>, <i>W</i>, <i>N</i>, <i>M</i>이 공백으로 구분되어 주어진다. (0 < <i>H</i>, <i>W</i>, <i>N</i>, <i>M</i> ≤ 50,000)</p>

### 출력 

 <p>강의실이 수용할 수 있는 최대 인원 수를 출력한다.</p>

### 접근 방법
- 가로에 앉은 사람 수 * 세로에 앉은 사람 수를 한다면 최대로 앉을 수 있는 사람 수 총합이 나오므로 다음과 같이 접근했다.
  - (0, 0)에 사람 하나는 무조건 앉혀놓고 시작한다고 가정했다.
  - 그리고 가로의 경우 (0, 1)부터 m + 1의 배수마다 사람 한 명이 앉는다.
  - 세로 역시 (1, 0)부터 n + 1의 배수마다 사람 한 명이 앉는다.
  - 이를 토대로 가로 및 세로에 앉은 사람을 구해서 결과를 도출했다.
