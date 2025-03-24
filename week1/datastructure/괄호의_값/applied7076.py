from collections import deque

s = input()
stack = deque()

total = 0
for item in s:
    if item == '(' or item == '[':
        stack.append(item)
    else:
        if item == ')':
            if stack and stack[-1] == '(':
                stack.pop()
                stack.append(2)
            else:
                if "(" not in stack:
                    print(0)
                    exit(0)
                inner = 0
                while stack:
                    top = stack.pop()
                    if top == '(':
                        stack.append(inner * 2)
                        break
                    elif top == '[':
                        print(0)
                        exit(0)
                    else:
                        inner += top
        elif item == ']':
            if stack and stack[-1] == '[':
                stack.pop()
                stack.append(3)
            else:
                if "[" not in stack:
                    print(0)
                    exit(0)
                inner = 0
                while stack:
                    top = stack.pop()
                    if top == '[':
                        stack.append(inner * 3)
                        break
                    elif top == '(':
                        print(0)
                        exit(0)
                    else:
                        inner += top

    while len(stack) > 1:
        if type(stack[-1]) == int and type(stack[-2]) == int:
            stack.append(stack.pop() + stack.pop())
        else:
            break

if '(' in stack or '[' in stack:
    print(0)
else:
    print(sum(stack))
