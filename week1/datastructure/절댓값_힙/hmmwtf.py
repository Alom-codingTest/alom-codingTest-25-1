import sys
import heapq
input = sys.stdin.readline
heap = []
n = int(input().strip())

for i in range(n):
    x = int(input().strip())
    if x != 0:
        heapq.heappush(heap, (abs(x), x))
    else:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)