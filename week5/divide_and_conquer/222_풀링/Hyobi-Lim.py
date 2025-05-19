import sys
n=int(sys.stdin.readline())
square=[]
for i in range(n):
    square.append(list(map(int,sys.stdin.readline().split())))
def check_square(square):
    new_square=[]
    new_num=len(square)//2
    for i in range(new_num):
        new=[]
        for j in range(new_num):
            four_square=square[2*i][2*j:2*(j+1)]
            four_square+=square[2*i+1][2*j:2*(j+1)]
            four_square.sort()
            new.append(four_square[2])
        new_square.append(new)
    return new_square
while(len(square)!=1):
    square=check_square(square)
print(*square[0])