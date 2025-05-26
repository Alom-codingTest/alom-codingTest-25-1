import sys, copy
input = sys.stdin.readline

N, M = map(int, input().split())
office = [list(map(int, input().split())) for _ in range(N)]
cctvs = []
for i in range(N):
    for j in range(M):
        if 1 <= office[i][j] <= 5:
            cctvs.append((i, j, office[i][j]))

dirs = {
    1: [[0], [1], [2], [3]],
    2: [[0,2], [1,3]],
    3: [[0,1], [1,2], [2,3], [3,0]],
    4: [[0,1,2], [1,2,3], [2,3,0], [3,0,1]],
    5: [[0,1,2,3]],
}

def watch(board, x, y, d):
    dx = [-1,0,1,0]
    dy = [0,1,0,-1]
    nx, ny = x + dx[d], y + dy[d]
    while 0 <= nx < N and 0 <= ny < M and board[nx][ny] != 6:
        if board[nx][ny] == 0:
            board[nx][ny] = '#'
        nx += dx[d]
        ny += dy[d]

min_blind = N * M
def dfs(idx, board):
    global min_blind
    if idx == len(cctvs):
        cnt = sum(row.count(0) for row in board)
        min_blind = min(min_blind, cnt)
        return

    x, y, ctype = cctvs[idx]
    for dirs_set in dirs[ctype]:
        temp = copy.deepcopy(board)
        for d in dirs_set:
            watch(temp, x, y, d)
        dfs(idx+1, temp)

dfs(0, office)
print(min_blind)
