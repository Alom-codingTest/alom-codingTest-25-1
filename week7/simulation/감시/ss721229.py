import sys
input = sys.stdin.readline

def watch(y, x, dirs, temp_map):
    updated = []
    for d in dirs:
        ny, nx = y, x
        while True:
            ny += dy[d]
            nx += dx[d]
            if 0 <= ny < N and 0 <= nx < M:
                if temp_map[ny][nx] == 6:  # 벽
                    break
                if temp_map[ny][nx] == 0:
                    temp_map[ny][nx] = '#'
                    updated.append((ny, nx))
            else:
                break
    return updated

def backtrack(depth, temp_map):
    global min_cnt

    if depth == len(cctvs):
        count = sum(row.count(0) for row in temp_map)
        min_cnt = min(min_cnt, count)
        return

    y, x, cctv_type = cctvs[depth]
    for dirs in cctv_directions[cctv_type]:
        modified = watch(y, x, dirs, temp_map)
        backtrack(depth + 1, temp_map)
        for ny, nx in modified:
            temp_map[ny][nx] = 0

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

cctv_directions = {
    1: [[0], [1], [2], [3]],
    2: [[0, 2], [1, 3]],
    3: [[0, 1], [1, 2], [2, 3], [3, 0]],
    4: [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
    5: [[0, 1, 2, 3]],
}

N, M = map(int, input().split())
office = []
cctvs = []
min_cnt = 64

for i in range(N):
    row = list(map(int, input().split()))
    office.append(row)
    for j in range(M):
        if 1 <= row[j] <= 5:
            cctvs.append((i, j, row[j]))

backtrack(0, [row[:] for row in office])
print(min_cnt)