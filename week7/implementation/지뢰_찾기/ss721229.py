import sys
input = sys.stdin.readline

def check_mine(a, b):
    dx = [0, 0, 1, 1, -1, -1, 1, -1]
    dy = [1, -1, 1, -1, 1, -1, 0, 0]
    cnt = 0
    for i in range(8):
        y = a + dy[i]
        x = b + dx[i]
        if 0 <= y < n and 0 <= x < n and mine_map[y][x] == '*':
            cnt += 1
    return cnt

n = int(input())
mine_map = [list(input()) for _ in range(n)]
played = [list(input()) for _ in range(n)]
result = [['.'] * n for _ in range(n)]
flag = False

for i in range(n):
    for j in range(n):
        if played[i][j] == 'x':
            if mine_map[i][j] == '*':
                flag = True
            result[i][j] = check_mine(i, j)

if flag:
    for i in range(n):
        for j in range(n):
            if mine_map[i][j] == '*':
                print('*', end='')
            else:
                print(result[i][j], end='')
        print()
else:
    for i in range(n):
        for j in range(n):
            print(result[i][j], end='')
        print()