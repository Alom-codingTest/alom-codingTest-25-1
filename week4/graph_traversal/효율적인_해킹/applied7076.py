from collections import defaultdict, deque

adj = defaultdict(list)

def bfs(start):
    visited = [False] * (n + 1)
    queue = deque([start])

    visited[start] = True
    while queue:
        now = queue.popleft()

        for next in adj[now]:
            if not visited[next]:
                visited[next] = True
                queue.append(next)

    return sum(visited)


if __name__ == "__main__":
    global n, m
    n, m = map(int, input().split())
    count = [0] * (n + 1)

    for _ in range(m):
        a, b = map(int, input().split())
        adj[b].append(a)

    for num in range(1, n+1):
        count[num] = bfs(num)

    maximum = max(count)
    answers = [i for i in range(1, n + 1) if count[i] == maximum]
    print(*answers)
    