T = int(input())

for _ in range(T):
    n, m = map(int, input().split())
    arr = [[0] * (m + 1) for _ in range(n + 1)]


    for i in range(1, n + 1):
        for j in range(i, m + 1):
            if i == 1:
                arr[i][j] = j
            else:
                if i == j:
                    arr[i][j] = 1
                else:
                    arr[i][j] = arr[i - 1][j - 1] + arr[i][j - 1]


    print(arr[n][m])
