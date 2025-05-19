import sys
num=int(sys.stdin.readline())
answer=[[' ']*num for _ in range(num)]
def fii_start(num,start_row,starl_col):
    global answer
    if num==1:
        return
    for i in range(3):
        for j in range(3):
            if i==1 and j==1:
                for a in range(num//3*i,num//3*(i+1)):
                    for b in range(num//3*j,num//3*(j+1)):
                        answer[start_row+a][starl_col+b]=' '
            else:
                for a in range(num//3*i,num//3*(i+1)):
                    for b in range(num//3*j,num//3*(j+1)):
                        answer[start_row+a][starl_col+b]='*'
                fii_start(num//3,start_row+num//3*i,starl_col+num//3*j)
fii_start(num,0,0)
for i in range(len(answer)):
    print(''.join(answer[i]))