import sys
input = sys.stdin.readline

t = int(input())
result = []
for i in range(t) :
    N = int(input())
    child = [[] for i in range(N+1)]
    parent = [0 for i in range(N+1)]
    for j in range(N-1) :
        a, b = map(int , input().split())
        child[a].append(b)
        parent[b] = a
        
    a, b = map(int,input().split())
    set1 = set()
    while True :
        set1.add(a)
        a = parent[a]
        if a == 0 :
            break
        
    while True :
        if b in set1 :
            break
        b = parent[b]
    result.append(b)
    
print(*result, sep='\n')
    
    