import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    parent = [0] * (N + 1)
    for _ in range(N - 1):
        A, B = map(int, input().split())
        parent[B] = A
    
    A, B = map(int, input().split())
    A_parent = set([A])

    while parent[A]:
        A_parent.add(parent[A])
        A = parent[A]

    while True:
        if B in A_parent:
            print(B)
            break
        B = parent[B]