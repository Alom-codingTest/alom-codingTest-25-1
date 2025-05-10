import sys

stack = []
laser = []
stick_start = []
stick_end = []
cnt = 1
stick_cnt=0
laser_cnt=0
while True:
    ch = sys.stdin.read(1)
    if ch != '\n':
        if ch == '(':
            stack.append(cnt)
        else:
            start = stack.pop()
            if (cnt - start) == 1:
                laser.append(cnt)
                laser_cnt=laser_cnt+1
            else:
                stick_start.append(start)
                stick_end.append(cnt)
                stick_cnt=stick_cnt+1
        cnt = cnt + 1
    else:
        break
total=0

for i in range(stick_cnt):
    w=1
    for j in range(laser_cnt):
        l=laser[j]
        if(l>stick_start[i] and l<stick_end[i]):
            w+=1
    total+=w
print(total)

ir= input()
stack=[]
cnt = 0
for i in range(len(ir)):
    if ir[i] == "(":
        stack.append("(")
    else :
        if ir[i-1]=="(":
            stack.pop()
            cnt+=len(stack) # 첫 번째 경우인 현재의 쇠막대기들을 카운팅합니다.
            
        else :
            stack.pop()
            cnt+=1 # 이 부분은 두 번째 경우인 나머지 부분을 세는 것입니다.
print(cnt)