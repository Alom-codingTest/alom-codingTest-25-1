import sys
from itertools import permutations
input=sys.stdin.readline
n=int(input())
w=[]
items=[]
for i in range(n):
    row=list(map(int,input().split()))
    w.append(row)
    items.append(i)
result=list(permutations(items, n))
min=10000000
for i in range(len(result)):
    cost=0
    l=result[i]
    flag=0
    for j in range(n-1):
        if w[l[j]][l[j+1]]==0:
            flag=1
            break

        cost+=w[l[j]][l[j+1]]
    if flag==1 or w[l[n-1]][l[0]]==0:
        continue
    cost+=w[l[n-1]][l[0]]
    if cost<min:
        min=cost
print(min)
