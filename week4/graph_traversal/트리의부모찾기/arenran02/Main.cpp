// 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

// 출력
// 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

const int MAX = 100001;
vector<int> tree[MAX];
int parent[MAX];
bool visited[MAX];

void bfs(int root) {
    queue<int> q;
    q.push(root);
    visited[root] = true;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        for (int next : tree[curr]) {
            if (!visited[next]) {
                parent[next] = curr;
                visited[next] = true;
                q.push(next);
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n - 1; ++i) {
        int a, b;
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }

    bfs(1); // 루트 노드 = 1

    for (int i = 2; i <= n; ++i) {
        cout << parent[i] << '\n';
    }

    return 0;
}
