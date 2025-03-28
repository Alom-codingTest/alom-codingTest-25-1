answer = 1000000000

def Burute(N, K):
    #n을 k개의 수로 나타내는 수
    method = [[0] * (N + 1) for _ in range(K + 1)]

    # 초기
    method[0][0] = 1

    for k in range(1, K + 1):
        for n in range(0, N + 1):
            method[k][n] = method[k-1][n]  # k-1 번째
            if n > 0:  
                method[k][n] += method[k][n-1]  #k개
            method[k][n] %= answer 

    return method[K][N]

#main

N, K = map(int, input().split())
print(Burute(N, K))
