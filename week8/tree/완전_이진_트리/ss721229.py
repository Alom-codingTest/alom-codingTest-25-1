import sys
input = sys.stdin.readline

def traversal(n):
    if n < 2 ** K:
        traversal(2 * n)
        result.append(tree[n])
        traversal(2 * n + 1)

K = int(input())
l = list(map(int, input().split()))
tree = [i for i in range(2**K)]
result = []
traversal(1)

answer = []
for i in range(1, 2**K + 1):
    for j in range(2**K - 1):
        if result[j] == i:
            answer.append(l[j])

idx = 0
for i in range(K):
    for j in range(2 ** i):
        print(answer[idx], end = ' ')
        idx += 1
    print()