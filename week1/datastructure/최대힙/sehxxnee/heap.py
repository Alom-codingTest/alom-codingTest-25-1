import sys
import heapq

N=int(sys.stdin.readline().strip())

heap=[]

for i in range(N):
    x = int(sys.stdin.readline().strip())

    if x > 0:
        heapq.heappush(heap,-x)

    elif x == 0:
        if heap:
            print(-heapq.heappop(heap))
        else:
            print(0)
        
