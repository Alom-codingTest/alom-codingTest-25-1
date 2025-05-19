N, M = map(int, input().split())
cardNums = list(map(int, input().split()))

# 카드 리스트를 정렬
cardNums.sort()

result = 0

# 첫 번째 카드 선택
for i in range(N-2):
    # 두 번째 카드 선택
    for j in range(i+1, N-1):
        # 세 번째 카드 선택
        for k in range(j+1, N):
            s = cardNums[i] + cardNums[j] + cardNums[k]
            if s > result and s <= M:
                result = s
            # 만약 합이 M을 초과하면 더 이상 탐색할 필요가 없으므로 break
            if s > M:
                break

print(result)