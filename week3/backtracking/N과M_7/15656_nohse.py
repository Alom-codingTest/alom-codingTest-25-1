import sys
from collections import deque
input=sys.stdin.readline
n,m=map(int, input().split())
arr=list(map(int, input().split()))
arr.sort()
que=deque()
def back():
    if len(que)==m:
        for i in range(m):
            print(que[i], end=" ")
        print()
        return
    for j in range(0, n):
        que.append(arr[j])
        back()
        que.pop()
back()
