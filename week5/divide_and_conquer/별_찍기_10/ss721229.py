import sys
input = sys.stdin.readline

def recur(y, x, num):
    if num == 0:
        return

    for i in range(num, num * 2):
        for j in range(num, num * 2):
            result[y + i][x + j] = ' '

    for i in range(0, num * 2 + 1, num):
        for j in range(0, num * 2 + 1, num):
                recur(y + i, x + j, num//3)

N = int(input())
result = []
for i in range(N):
    result.append(['*' for _ in range(N)])

recur(0, 0, N//3)

for i in range(N):
    for j in range(N):
        print(result[i][j], end='')
    print()