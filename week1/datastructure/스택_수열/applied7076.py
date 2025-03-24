from collections import deque

if __name__ == "__main__":
    n = int(input())
    result = deque([int(input()) for _ in range(n)])
    # print(result)

    stack = deque()
    answer = []

    for i in range(1, n+1):
        stack.append(i)
        answer.append('+')

        while stack and stack[-1] == result[0]:
            stack.pop()
            result.popleft()
            answer.append('-')

    print('NO' if stack else '\n'.join(answer))