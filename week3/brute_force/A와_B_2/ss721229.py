# 1h 30m
import sys
input = sys.stdin.readline

result = 0
def dfs(T):
    global result

    if T == S:
        result = 1
        return

    if len(T) == 0:
        return

    if T[-1] == 'A':
        dfs(T[:-1])
    
    if T[0] == 'B':
        dfs(T[::-1][:-1])

S = input().rstrip()
T = input().rstrip()

dfs(T)
print(result)