n, m = map(int, input().split())
adj = [[] for _ in range(n + 1)]
ind = [0 for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]

for _ in range(m):
    li = list(map(int, input().split()))[1:]

    for i in range(len(li) - 1):
        adj[li[i]].append(li[i + 1])
        ind[li[i + 1]] += 1

q = []

for i in range(1, n + 1):
    if not visited[i] and ind[i] == 0:
        visited[i] = True
        q.append(i)

res = []

while q:
    now = q.pop(0)
    res.append(now)

    for x in adj[now]:
        ind[x] -= 1
    adj[now].clear()

    for i in range(1, n + 1):
        if not visited[i] and ind[i] == 0:
            visited[i] = True
            q.append(i)

if len(res) == n:
    print(*res, sep='\n')
else:
    print(0)