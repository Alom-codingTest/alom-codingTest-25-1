import sys
from collections import deque
n,m=map(int,sys.stdin.readline().split())
sequence={i:set() for i in range(1,n+1)}
for i in range(m):
    arr=list(map(int,sys.stdin.readline().split()))
    for j in range(2,arr[0]+1):
        sequence[arr[j]].add(arr[j-1])
sequence_queue=deque()
for i in sequence:
    if len(sequence[i])==0:
        sequence_queue.append(i)
answer=[]
while(sequence_queue):
    now=sequence_queue.popleft()
    if now in answer:
        continue
    answer.append(now)
    del sequence[now]
    for i in sequence:
        if now in sequence[i]:
            sequence[i].remove(now)
        if len(sequence[i])==0:
            sequence_queue.append(i)
if len(answer)!=n:
    print(0)
else:
    for i in answer:
        print(i)