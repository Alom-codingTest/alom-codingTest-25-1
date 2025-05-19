import heapq
import sys
input = sys.stdin.readline

N = int(input())
que = []
for _ in range(N):
    x = int(input())

    if x != 0:
        heapq.heappush(que, (abs(x), x))

    else:
        if len(que) == 0:
            print(0)
        else:
            print(heapq.heappop(que)[1])