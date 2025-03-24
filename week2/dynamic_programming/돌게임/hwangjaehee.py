# a + 3b = N (a: 1개 가져가는 횟수, b:3개 가져가는 횟수)
# b=0일때, b=1일때, ... N-3b>=0까지
# a+b가 홀수면 SK가 승자, 짝수면 CY가 승자

N = int(input())
winner = ""

for b in range((N // 3) + 1):
    a = N - (3 * b) 
    
    if a < 0:
        break
    # a+b의 합의 홀짝 판정
    if (a + b) % 2 == 1:
        winner = "SK"   # 홀수면 상근이가 승자
    else:
        winner = "CY"   # 짝수면 창영이가 승자

# 승자 출력
print(winner)