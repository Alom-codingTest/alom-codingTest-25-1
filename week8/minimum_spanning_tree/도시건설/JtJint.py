import sys, copy
input = sys.stdin.readline

N, M = map(int, input().strip().split(' '))
roads = []
parent = [_ for _ in range(N+1)]
total_cost = 0
def find_parent(prarent,x) :
    if parent[x] != x :
        parent[x] = find_parent(parent, parent[x])
    return parent[x]
def union_parent(parent, a, b) :
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b :
        parent[b] = a
    else :
        parent[a] = b
for _ in range(M) :
    a, b, c= map(int, input().strip().split(' '))
    roads.append((c,a,b))
    total_cost+= c

roads.sort()

def kruskal() :
    cost = 0
    for tmpcost, st, ed  in (roads) :
        if find_parent(parent, st) != find_parent(parent, ed) :
            union_parent(parent, st, ed)
            # print (st, ed)
            cost+= tmpcost
            
    return total_cost - cost

rt = kruskal()
set1 = set()
for i in range(1,len(parent)):
    p = find_parent(parent, parent[i])
    if parent[i] != p  :
        parent[i] = p
    set1.add(p)

if len(set1) != 1 :
    print(-1)
else :
    print(rt)
