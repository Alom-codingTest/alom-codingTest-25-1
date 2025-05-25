// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

// 입력
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

// 출력
// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

vector<vector<int>> graph;
vector<bool> visited;

// DFS 구현
void dfs(int v) {
    visited[v] = true;
    cout << v << " ";
    for (int u : graph[v]) {
        if (!visited[u]) {
            dfs(u);
        }
    }
}

// BFS 구현
void bfs(int v) {
    queue<int> q;
    vector<bool> visited_bfs(graph.size(), false);
    q.push(v);
    visited_bfs[v] = true;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        cout << curr << " ";

        for (int u : graph[curr]) {
            if (!visited_bfs[u]) {
                q.push(u);
                visited_bfs[u] = true;
            }
        }
    }
}

int main() {
    int n, m, start;
    cin >> n >> m >> start;

    graph.resize(n + 1);
    visited.resize(n + 1, false);

    // 간선 입력
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a); // 양방향
    }

    // 인접 리스트 정렬 => 번호가 작은 정점 먼저 방문하기 위해
    for (int i = 1; i <= n; i++) {
        sort(graph[i].begin(), graph[i].end());
    }

    dfs(start);
    cout << "\n";
    bfs(start);

    return 0;
}
