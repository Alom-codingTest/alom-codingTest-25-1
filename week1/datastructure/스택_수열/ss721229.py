import sys
input = sys.stdin.readline

N = int(input())

stack = list()
result = list()
append_cnt = 1
flag = 0

for i in range(N):
    num = int(input())

    if stack and stack[-1] == num:
        stack.pop()
        result.append('-')
    else:
        while not flag:
            stack.append(append_cnt)
            append_cnt += 1
            result.append('+')

            if stack[-1] == num:
                stack.pop()
                result.append('-')
                break
            elif append_cnt > N + 1:
                flag = 1
                break
if not flag:
    for x in result:
        print(x)
else:
    print('NO')