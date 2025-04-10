# 입력 받기
n, m = map(int, input().split())
cards = list(map(int, input().split()))
result = 0

# 3장의 카드 조합을 확인인
for i in range(n):
    for j in range(i + 1, n):
        for k in range(j + 1, n):
            total = cards[i] + cards[j] + cards[k]
            # total<= M, && M에 가까운 값
            if total <= m:
                result = max(result, total)
                
print(result)
