import sys
n=int(sys.stdin.readline())
mine=set()
for i in range(n):
    arr=list(sys.stdin.readline().strip())
    for j in range(n):
        if arr[j]=='*':
            mine.add((i,j))
answer=[]
mine_check=False
for i in range(n):
    arr=list(sys.stdin.readline().strip())
    for j in range(n):
        if arr[j]=='x':
            if (i,j) in mine:
                mine_check=True
            else:
                cnt=0
                for a in range(-1,2):
                    for b in range(-1,2):
                        if (i+a,j+b) in mine:
                            cnt+=1
                arr[j]=str(cnt)
    answer.append(arr)
if mine_check:
    for i in mine:
        answer[i[0]][i[1]]='*'
for i in answer:
    for j in i:
        print(j,end='')
    print()