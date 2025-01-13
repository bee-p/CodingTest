#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int N;
    cin >> N;

    int* time = new int[N]();
    for (int i = 0; i < N; i++)
    {
        cin >> time[i];
    }

    sort(time, time + N);

    int result = 0;
    for (int i = 0; i < N; i++)
        for (int k = 0; k <= i; k++)
            result += time[k];

    cout << result;

    delete[] time;
}