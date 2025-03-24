import sys 

# n이 과목의 수고 m이 선수 조건의 수
N,M=map(int,sys.stdin.readline().strip().split())
 
# 0이 n개 들어가있는 리스트 선언
list=N*[0] #진입차수
#최소
# [0,0,0,0,0]
for _ in range (M):
    #A가 B의 선수과목
    A,B=map(int,sys.stdin.readline().strip().split())
    list[B-1]+=1

print(list)

