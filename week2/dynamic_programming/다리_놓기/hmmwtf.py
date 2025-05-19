#백준 1010 다리 놓기
#이 문제는 읽고나서 경우의 수를 떠올렸다. 원래는 itettools의 combination을 이용하려고 했지만 
#이미 math 함수의 combination을 구해주는 함수가 존재하여 사용했습니다. 
import sys, math
input = sys.stdin.readline

t = int(input().strip())
for _ in range(t):
    n,m = map(int, input().strip().split())
    print(math.comb(m, n))