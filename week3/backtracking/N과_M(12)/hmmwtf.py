import sys
from itertools import combinations_with_replacement

input = sys.stdin.readline

n, m = map(int, input().strip().split())
arr = sorted(list(map(int, input().strip().split())))
result = set()

for comb in combinations_with_replacement(arr, m):
    result.add(comb)

for ans in sorted(result):
    print(' '.join(map(str, ans)))