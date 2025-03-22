# 2시간 30분
import sys
input = sys.stdin.readline

def cal(num, weight):
    if num > N:
        return
    if l[num][weight]:
        return
    
    l[num][weight] = True

    cal(num + 1, weight + weights[num])
    cal(num + 1, weight)
    cal(num + 1, abs(weight - weights[num]))

N = int(input())
weights = list(map(int,input().split())) + [0]

M = int(input())
bead = list(map(int,input().split()))

l = [[False] * 15001 for _ in range(31)]
cal(0, 0)

result = []
for b in bead:
    if b <= 15000 and l[N][b]:
        result.append('Y')
    else:
        result.append('N')
print(*result)