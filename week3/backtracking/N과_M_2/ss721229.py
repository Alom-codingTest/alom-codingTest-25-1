# N분
import sys
input = sys.stdin.readline

def recur(start):
    if len(l) == M:
        print(*l)
        return
    
    for i in range(start, N + 1):
        if i not in l:
            l.append(i)
            recur(i + 1)
            l.pop()

N, M = map(int, input().split())
l = []
recur(1)