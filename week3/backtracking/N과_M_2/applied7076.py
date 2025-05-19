global n, m, arr

# 지금 now까지 count개를 선택했다 
def backtrack(now, cnt):
    if cnt == m:
        print(*arr)
        return
    
    for i in range(now + 1, n + 1):
        arr[cnt] = i
        backtrack(i, cnt + 1)


if __name__ == "__main__": 
    n, m = map(int, input().split())
    arr = [0] * m

    for i in range(1, n + 1):
        arr[0] = i
        backtrack(i, 1)
