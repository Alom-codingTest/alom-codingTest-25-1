n,m,v = map(int,input().split())

graph = [[0]*(n+1) for _ in range(n+1)]
for i in range (m):
    a,b = map(int,input().split())
    graph[a][b] = graph[b][a] = 1

visit1 = [0]*(n+1)
visit2 = visit1.copy()

def dfs(V):
    visit1[V] = 1 #방문 표시
    print(V, end=' ')
    for i in range(1, n+1):
        if graph[V][i] == 1 and visit1[i] == 0:
            dfs(i)

def bfs(V):
    queue = [V]
    visit2[V] = 1
    while queue:
        V = queue.pop(0)
        print(V, end = ' ')
        for i in range(1, n+1):
            if(visit2[i] == 0 and graph[V][i] == 1):
                queue.append(i)
                visit2[i] = 1

dfs(v)
print()
bfs(v)