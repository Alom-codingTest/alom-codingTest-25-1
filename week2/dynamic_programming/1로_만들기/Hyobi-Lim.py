import sys
n=int(sys.stdin.readline())
answer=0
def makeone(n,count):
    global answer
    if n==1:
        if answer==0 or count<answer:
            answer=count
        return
    elif answer!=0 and count>=answer:
        return
    else:
        if n%3==0:
            makeone(n//3,count+1)
        if n%2==0:
            makeone(n//2,count+1)
        makeone(n-1,count+1)
makeone(n,0)
print(answer)