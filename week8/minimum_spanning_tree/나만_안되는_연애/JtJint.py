import sys
input = sys.stdin.readline

N, M = map(int, input().strip().split())
universityList = list(map(str, input().strip().split(' ')))
edgesList = []
parent = [_ for _ in range(N+1)]

def find_parent(parent, u) :
    if u != parent[u] :
        parent[u] = find_parent(parent, parent[u])
    return parent[u]
    
def union_parent(parent, u, v) :
    a, b = find_parent(parent,u), find_parent(parent, v)
    if a == b :
        return
    if a < b :
        parent[b] = a
    else :
        parent[a] = b

for _ in range(M) :
    u,v, d = map(int , input().split())
    edgesList.append((d,(u,v)))
    
edgesList.sort()
totalDistance = 0
cnt = 0

for i in range(M) :
    if cnt == N-1 :
        break
    d, (u , v) = edgesList[i]
    if universityList[u-1] == universityList[v-1]  :
        continue
    if find_parent(parent, u) == find_parent(parent, v) :
        continue
    union_parent(parent, u , v)
    totalDistance += d
    cnt += 1

if cnt == N-1 :
    print(totalDistance)
else :
    print(-1)

# 3 3
# M W M
# 1 2 1 
# 2 3 1
# 1 3 1
# ans : 2