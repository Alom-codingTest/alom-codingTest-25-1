n = int(input())
li = []

for _ in range(n):
    li += map(int, input().split())
    li.sort(reverse=True)
    li = li[:n]

print(li[n-1])