import sys
n,m=map(int,sys.stdin.readline().split())
class_dict=dict()
for i in range(1,n+1):
    class_dict[i]=[]
for i in range(m):
    a,b=map(int,sys.stdin.readline().split())
    class_dict[a].append(b)
answer=[1]*n
for i in range(1,n+1):
    for j in class_dict[i]:
        answer[j-1]=max(answer[j-1],answer[i-1]+1)
print(*answer)