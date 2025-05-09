import sys
input = sys.stdin.readline
from collections import deque
n, m = map(int, input().split(" "))
tmp = []

for i in range(n) :
    tmp.append([False]*n)

for i in range(m) :
    a,b = map(int, input().split(" "))
    tmp[a-1][b-1] = True

prt = [0]*n

for i in range(n) :
    prt[i] = max(prt[i], 1)
    for j in range(n) :
        if tmp[i][j] :
            prt[j] = max(prt[j], prt[i]+1)
            

for i in range(n) :
    print(prt[i], end= ' ')