import sys
input = sys.stdin.readline

def recur(y, x, num):
    global result
    if r == y and c == x:
        return

    if r < y + num and c < x + num:
        recur(y, x, num//2)
    elif r >= y + num and c < x + num:
        result += num * num * 2
        recur(y+num, x, num//2)
    elif r < y + num and c >= x + num:
        result += num * num
        recur(y, x+num, num//2)
    elif r >= y + num and c >= x + num:
        result += num * num * 3
        recur(y+num, x+num, num//2)

N, r, c = map(int, input().split())
result = 0
recur(0, 0, 2**N//2)
print(result)