import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 거리 배열을 -1로 초기화 (아직 방문하지 않은 상태)
dist = [[-1] * m for _ in range(n)]
dq = deque()

# 1인 칸들은 거리를 0으로 하고 큐에 넣어 둔다.
for i in range(n):
    for j in range(m):
        if grid[i][j] == 1:
            dist[i][j] = 0
            dq.append((i, j))

# 4방향 델타
dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# 멀티소스 BFS 시작
while dq:
    i, j = dq.popleft()
    for di, dj in dirs:
        ni, nj = i + di, j + dj
        # 경계 안에 있고 아직 방문 전(-1)이라면,
        if 0 <= ni < n and 0 <= nj < m and dist[ni][nj] == -1:
            dist[ni][nj] = dist[i][j] + 1
            dq.append((ni, nj))

# 결과 출력
for i in range(n):
    print(*dist[i])
