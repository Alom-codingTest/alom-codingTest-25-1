import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int, input().split())
arr=list(map(int,input().split()))
arr.sort()

que=deque()
result=set()
def back():
    if len(que)==m:
        result.add(tuple(que))
        return
    
    for j in range(n):
        que.append(arr[j])
        back()
        que.pop()
back()
for seq in sorted(result):  # 튜플들을 정렬해서 순서대로 출력
    print(*seq)
