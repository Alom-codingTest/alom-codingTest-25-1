import sys
from heapq import heappush, heappop

input = sys.stdin.readline

N = int(input())
min_heap, max_heap = [], []
solved_prm_max, solved_prm_min = set(), set()

for i in range(N):
    P, L = map(int, input().split())
    heappush(min_heap, (L, P))
    heappush(max_heap, (-L, -P))

M = int(input())
for i in range(M):
    cmd = list(input().split())
    if cmd[0] == 'add':
        P, L = int(cmd[1]), int(cmd[2])
        heappush(min_heap, (L, P))
        heappush(max_heap, (-L, -P))
    elif cmd[0] == 'recommend':
        if int(cmd[1]) == 1:
            # 가장 어려운 문제 (문제 번호가 가장 큰 것)
            while True:
                if -max_heap[0][1] in solved_prm_max:
                    solved_prm_max.remove(-max_heap[0][1])
                    heappop(max_heap)
                else:
                    break
            print(-max_heap[0][1])
        elif int(cmd[1]) == -1:
            # 가장 쉬운 문제 (문제 번호가 가장 작은 것)
            while True:
                if min_heap[0][1] in solved_prm_min:
                    solved_prm_min.remove(min_heap[0][1])
                    heappop(min_heap)
                else:
                    break
            print(min_heap[0][1])
    elif cmd[0] == 'solved':
        solved_prm_max.add(int(cmd[1]))
        solved_prm_min.add(int(cmd[1]))