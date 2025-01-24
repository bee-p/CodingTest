#include <iostream>
#include <queue>

using namespace std;

int main()
{
	int N;
	cin >> N;

	if (N == 1)
	{
		cout << 0;
		return 0;
	}

	// 우선순위 큐
	// 작은 것부터 추출되도록
	priority_queue<int, vector<int>, greater<int>> card;
	for (int i = 0; i < N; i++)
	{
		int a;
		cin >> a;
		card.push(a);
	}

	int result = 0;
	while (card.size() > 1)
	{
		int a = card.top();
		card.pop();

		int b = card.top();
		card.pop();

		card.push(a + b);
		result += a + b;
	}

	cout << result;
}