import sys
input=sys.stdin.readline
n=int(input())
for i in range(n):
    w=[]
    row=[]
    for j in range(3):
        row=list(input().split())
        w.append(row)
    print(w)