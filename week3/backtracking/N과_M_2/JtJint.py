def backtrack(start, path):
    if len(path) == M: 
        print(*path)
        return
    
    for i in range(start, N + 1):  
        backtrack(i, path + [i])  

N, M = map(int, input().split())

backtrack(1, [])
