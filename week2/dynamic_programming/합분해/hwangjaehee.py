import math
# 0이상의 수 더하기 문제 관점) -> n+k-1 C k-1

N, k = map(int, input().split())
# n+k-1 C k-1 계산
numerator = math.factorial(N + k - 1)
denominator = math.factorial(k - 1) * math.factorial(N)

result = numerator // denominator  # 정수 나눗셈
print(result % 1000000000)