import sys
input = sys.stdin.readline

N = int(input())
nums = list()

for i in range(N):
    nums.extend(list(map(int, input().split())))
    nums.sort(reverse=True)
    len_nums = len(nums) - N
    for j in range(len_nums):
        nums.pop()

print(nums[-1])