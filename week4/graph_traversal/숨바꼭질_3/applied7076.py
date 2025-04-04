INF = 1000000007

start, end = map(int, input().split())
dist = [INF] * 100001

dist[start] = 0
queue = [start]
while queue:
    now = queue.pop(0)  # 그냥 이럴거였으면 효율적인 해킹도 collections import 안해도 됐을듯

    if now == end:
        print(dist[now])
        exit(0)
        
    for next in [now * 2, now - 1, now + 1]:
        if 0 <= next < 100001 and dist[next] == INF:
            dist[next] = dist[now] + (0 if next == now * 2 else 1)
            queue.append(next)

print(-1)