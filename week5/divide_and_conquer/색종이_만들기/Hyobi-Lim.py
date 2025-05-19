import sys
n=int(sys.stdin.readline())
square=[]
for i in range(n):
    square.append(list(map(int,sys.stdin.readline().split())))
white_square=0
blue_square=0
def check_square(start_x,start_y,num):
    global white_square,blue_square
    if num==1:
        if square[start_x][start_y]==0:
            white_square+=1
        else:
            blue_square+=1
        return
    else:
        arr=[]
        for i in range(num):
            arr+=square[start_x+i][start_y:start_y+num]
        if 0 in arr and 1 in arr:
            new_num=num//2
            check_square(start_x,start_y,new_num)
            check_square(start_x+new_num,start_y,new_num)
            check_square(start_x,start_y+new_num,new_num)
            check_square(start_x+new_num,start_y+new_num,new_num)
        elif 0 in arr:
            white_square+=1
            return
        else:
            blue_square+=1
            return
check_square(0,0,n)
print(white_square)
print(blue_square)