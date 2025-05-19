import sys
n,r,c=map(int,sys.stdin.readline().split())
num=0
def z(now_n,start_r,start_c):
    global num
    if now_n==1:
        if start_r==r and start_c==c:
            return
    else:
        half=now_n//2
        if start_r<=r<start_r+half and start_c<=c<start_c+half:
            z(half,start_r,start_c)
        elif start_r<=r<start_r+half and start_c+half<=c<start_c+half*2:
            num+=half*half
            z(half,start_r,start_c+half)
        elif start_r+half<=r<start_r+half*2 and start_c<=c<start_c+half:
            num+=(half*half)*2
            z(half,start_r+half,start_c)
        elif start_r+half<=r<start_r+half*2 and start_c+half<=c<start_c+half*2:
            num+=(half*half)*3
            z(half,start_r+half,start_c+half)
z(2**n,0,0)
print(num)