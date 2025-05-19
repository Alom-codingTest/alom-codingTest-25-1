import sys
from collections import deque
n,k=map(int,sys.stdin.readline().split())
queue=deque([n])
node_time=dict()
node_time[n]=0
while(k not in node_time):
    now=queue.popleft()
    if 0<=now*2<=100000 and now*2 not in node_time:
        node_time[now*2]=node_time[now]
        if now*2 not in queue:
            queue.appendleft(now*2)
    if 0<=now-1<=100000 and now-1 not in node_time:
        node_time[now-1]=node_time[now]+1
        if now-1 not in queue:
            queue.append(now-1)
    if 0<=now+1<=100000 and now+1 not in node_time:
        node_time[now+1]=node_time[now]+1
        if now+1 not in queue:
            queue.append(now+1)

print(node_time[k])
