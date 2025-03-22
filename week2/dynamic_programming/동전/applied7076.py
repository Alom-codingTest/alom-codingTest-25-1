t = int(input())

for _ in range(t):
    n = int(input())
    coins = list(map(int, input().split()))
    price = int(input())

    # price가 충분히 작음, 만들 수 있는 경우의 수를 누적하면서 계산
    dp = [0] * (price + 1)

    dp[0] = 1
    for coin in coins:
        # i원을 만드는 방법에 i - coin원 만드는 법 추가 -> (i - coin) + coin이라는 새로운 방법이 dp[i - coin]만큼 추가
        for i in range(coin, price + 1):
            dp[i] += dp[i - coin]

    print(dp[price])