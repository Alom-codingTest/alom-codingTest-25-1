import sys

n = int(input())
block=[]
for i in range(n):
    tmp = list(map(int, sys.stdin.readline().strip().split()))
    block.append(tmp)

while 1:
    if len(block[0])==1:
        print(block[0][0])
        break

    makeBlock = [item[:] for item in block]

    block = []
    for i in range(0, len(makeBlock),2):
        tmp=[]
        for j in range(0, len(makeBlock[0]),2):
            realT=[makeBlock[i][j], makeBlock[i][j+1], makeBlock[i+1][j], makeBlock[i+1][j+1]]
            realT.sort(reverse=True)
            tmp.append(realT[1])

        block.append(tmp)
