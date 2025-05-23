import sys
input = sys.stdin.readline

k = int(input())
t1 = list(map(int, input().strip().split(' ')))
t2 = list(map(int, input().strip().split(' ')))

t1D = [[0]*(2**(k-1)+1) for i in range((2**(k-1))+1)]
t2D = [[0]*(2**(k-1)+1) for i in range((2**(k-1))+1)]

for i in range(2**(k-1)) :
    for j in range(2**(k-1)) :
        cnt = 0
        if i == j :
            continue
        tmpk, st ,ed = k , i, j
        while st != ed:
            st //= 2
            ed //= 2
            cnt += 2
        t1D[t1[i]][t1[j]] = cnt
        t1D[t1[j]][t1[i]] = cnt
        t2D[t2[i]][t2[j]] = cnt
        t2D[t2[j]][t2[i]] = cnt
        
lst = []
for i in range(1,len(t1D)) :
    set1 = set()
    for j in range(1,len(t2D)) :
        if t1D[i][j] == t2D[i][j] :
            set1.add(j)
    lst.append((i,set1))
    
prt = []
for i in range(len(lst)):    
    cnt = 0
    for j in lst[i][1] :
        if lst[i][1] ==  lst[j-1][1] :
            cnt += 1
    if cnt == len(lst[i][1]) :
        prt.append(i+1)

print(len(prt))
    
