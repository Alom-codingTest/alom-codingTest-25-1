n, m = map(int, input().split())
adj = [[] for _ in range(n + 1)]
ind = [0 for _ in range(n + 1)]
res = [1 for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    adj[a].append(b)
    ind[b] += 1

q = []

for i in range(1, n + 1):
    if not visited[i] and ind[i] == 0:
        visited[i] = True
        q.append(i)

while q:
    now = q.pop(0)

    for x in adj[now]:
        ind[x] -= 1
    adj[now].clear()

    # print(adj, ind)

    for i in range(1, n + 1):
        if not visited[i] and ind[i] == 0:
            visited[i] = True
            res[i] = res[now] + 1
            q.append(i)

print(' '.join(str(x) for x in res[1:]))