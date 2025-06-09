import sys
from collections import deque
input=sys.stdin.readline
n,m=map(int, input().split())
arr=list(map(int, input().split()))
arr.sort()
que=deque()
def back(start):
    if len(que)==m:
        for i in range(m):
            print(que[i], end=" ")
        print()
        return
    for j in range(start, n):
        if j > start and arr[j] == arr[j - 1]:
            continue
        que.append(arr[j])
        back(j+1)
        que.pop()
back(0)