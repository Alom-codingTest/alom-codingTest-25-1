import sys
input = sys.stdin.readline

H, W = map(int, input().split())
l = list(map(int, input().split()))
world = [[0] * W for _ in range(H)]
total = 0

for i in range(W):
    for j in range(l[i]):
        world[j][i] = 1

for i in range(H):
    cnt = 0
    idx = 0
    while idx < W:
        while idx < W and world[i][idx] == 0:
            idx += 1 
        if idx == W:
            break
        if world[i][idx] == 1:
            idx += 1

        while idx < W and world[i][idx] == 0:
            cnt += 1
            idx += 1
    
        if idx < W and world[i][idx] == 1: 
            total += cnt
            cnt = 0
        
print(total)


