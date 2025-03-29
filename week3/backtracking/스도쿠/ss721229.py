# lh
import sys
input = sys.stdin.readline

def check(val, y, x):
    for i in range(9): # 가로 세로
        if val == l[i][x] or val == l[y][i]:
            return False
        
    for i in range(3): # 3 * 3 사각형
        for j in range(3):
            if val == l[y//3 * 3 + i][x//3 * 3 + j]:
                return False
    return True

def back_tracking(n):
    if n == len(blank):
        for line in l:
            print(*line)
        exit()
    
    for val in range(1, 10):
        y, x = blank[n]

        if check(val, y, x):
            l[y][x] = val
            back_tracking(n + 1)
            l[y][x] = 0

l = [list(map(int, input().split())) for _ in range(9)]
blank = []

for i in range(9):
    for j in range(9):
        if l[i][j] == 0:
            blank.append((i, j))

back_tracking(0)