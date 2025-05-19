import sys
input = sys.stdin.readline

st = input().rstrip()

stack = list()
result = 0
num = 1

for i in range(len(st)):
    if st[i] == '(':
        stack.append(st[i])
        num *= 2
    elif st[i] == '[':
        stack.append(st[i])
        num *= 3
    elif st[i] == ')':
        if not stack or stack[-1] == '[':
            result = 0
            break
        stack.pop()
        if st[i - 1] == '(':
            result += num
        num //= 2
    elif st[i] == ']':
        if not stack or stack[-1] == '(':
            result = 0
            break
        stack.pop()
        if st[i - 1] == '[':
            result += num
        num //= 3

if stack:
    print(0)
else:
    print(result)