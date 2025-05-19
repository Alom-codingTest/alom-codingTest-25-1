n, m = map(int, input().split())
arr = list(map(int, input().split()))

res = []
arr = list(set(arr))
arr.sort()

def func(k):
    if k == m:
        print(*res)
        return

    for i in range(len(arr)):
        if not res or res[-1] <= arr[i]:
            res.append(arr[i])
            func(k + 1)
            res.pop()

func(0)
