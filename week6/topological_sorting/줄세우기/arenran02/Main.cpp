#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 이분 탐색을 이용한 O(N log N) 방식의 LIS 계산
int findLISLength(const vector<int>& arr) {
    vector<int> lis;
    for (int num : arr) {
        auto it = lower_bound(lis.begin(), lis.end(), num);
        if (it == lis.end()) {
            lis.push_back(num);
        } else {
            *it = num;
        }
    }
    return lis.size();
}

int main() {
    int N;
    cin >> N;
    vector<int> children(N);
    for (int i = 0; i < N; ++i) {
        cin >> children[i];
    }

    int lisLength = findLISLength(children);
    int minMoves = N - lisLength;

    cout << minMoves << endl;

    return 0;
}
