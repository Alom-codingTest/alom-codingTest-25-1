import sys
from collections import deque
input=sys.stdin.readline
n,m=map(int, input().split())
arr=list(map(int, input().split()))
arr.sort()
que=deque()
def reverse():
    if len(que)==m:
        for j in range(m):
            print(que[j], end=" ")
        print()
        return
    for i in range(n):
        if arr[i] not in que:
            que.append(arr[i])
            reverse()
            que.pop()

reverse()