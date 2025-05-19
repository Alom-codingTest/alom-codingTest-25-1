import sys
input = sys.stdin.readline

def recur(p, num):
    if num == 1:
        print(p[0][0])
        return
    next_p = []
    for i in range(0, num, 2):
        line = []
        for j in range(0, num, 2):
            tmp = [p[i][j], p[i + 1][j], p[i][j + 1], p[i + 1][j + 1]]
            line.append(sorted(tmp)[-2])
        next_p.append(line)
    
    recur(next_p, num//2)

N = int(input())
pool = [list(map(int, input().split())) for _ in range(N)]
recur(pool, N)