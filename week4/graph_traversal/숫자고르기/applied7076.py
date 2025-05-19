from collections import deque, defaultdict

adj = defaultdict(list)

def bfs(start):
    # 더 좋은 방법 없나?
    s = [False] * (n + 1)
    e = [False] * (n + 1)
    queue = deque([start])
    
    s[start] = True
    while queue:
        now = queue.popleft()

        for next in adj[now]:
            e[next] = True
            if next == now:
                continue

            if not s[next]:
                s[next] = True
                queue.append(next)

    return [i for i in range(1, n+1) if s[i]] if s == e else []


if __name__ == "__main__":
    global n
    n = int(input())

    for i in range(1, n+1):
        a = int(input())
        adj[i].append(a)

    res = set()
    for i in range(1, n+1):
        if i not in res:
            bfs_res = bfs(i)

            for item in bfs_res:
                res.add(item)

    print(len(res))
    print(*sorted(list(res)), sep='\n')