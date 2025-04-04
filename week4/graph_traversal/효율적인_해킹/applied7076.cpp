#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
#ifdef ONLINE_JUDGE
#define NDEBUG
#endif
#define all(x) (x).begin(), (x).end()
#define mod 1'000'000'007
#define endl '\n'

typedef vector<int> vi;
typedef vector<bool> vb;
typedef vector<vector<int>> vvi;
vvi adj;
int n, m;

int bfs(int start) {
    queue<int> q;
    vb visited(n + 1, false);

    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int next : adj[now]) {
            if (!visited[next]) {
                visited[next] = true;
                q.push(next);
            }
        }
    }

    return count(all(visited), true);
}

int main() {
    FAST_IO;

    cin >> n >> m;
    adj.resize(n + 1);

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        adj[b].push_back(a);
    }

    vi count(n + 1, 0);
    for (int i = 1; i <= n; i++) {
        count[i] = bfs(i);
    }

    int max_count = *max_element(all(count));
    for (int i = 1; i <= n; i++) {
        if (count[i] == max_count) {
            cout << i << ' ';
        }
    }
}