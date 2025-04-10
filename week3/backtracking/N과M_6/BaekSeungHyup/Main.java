def backtrack(start, path):
    # M개 선택후 출력
    if len(path) == m:
        print(*path)
        return

    for i in range(start, n):
        backtrack(i + 1, path + [numbers[i]])

# Main

n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()  # 사전 정렬

backtrack(0, [])
