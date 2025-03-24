from heapq import heappop, heappush
import sys

input = sys.stdin.readline
print = sys.stdout.write
maxProb = []
minProb = []
solvMaxProb = set()
solvMinProb = set()

n = int(input())
for i in range(n):
    p, l = map(int, input().split())
    heappush(maxProb, (-l, -p))
    heappush(minProb, (l, p))

m = int(input())
for i in range(m):
    cmd = input().split()

    if cmd[0] == 'recommend':
        x = int(cmd[1])
        if x == 1:
            while -maxProb[0][1] in solvMaxProb:
                solvMaxProb.remove(-maxProb[0][1])
                heappop(maxProb)

            print(str(-maxProb[0][1]))
            print("\n")
        else:
            while minProb[0][1] in solvMinProb:
                solvMinProb.remove(minProb[0][1])
                heappop(minProb)

            print(str(minProb[0][1]))
            print("\n")

    elif cmd[0] == 'add':
        p = int(cmd[1])
        l = int(cmd[2])
        heappush(maxProb, (-l, -p))
        heappush(minProb, (l, p))

    elif cmd[0] == 'solved':
        p = int(cmd[1])
        solvMaxProb.add(p)
        solvMinProb.add(p)