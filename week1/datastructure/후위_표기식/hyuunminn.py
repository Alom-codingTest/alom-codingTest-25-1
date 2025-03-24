arr = list(input())
stack = []
res = ''

for item in arr:
    if item.isalpha():
        res += item
    else:
        if item == '(':
            stack.append(item)
        elif item == '*' or item == '/':
            while stack and (stack[-1] == '*' or stack[-1] =='/'):
                res += stack.pop()
            stack.append(item)
        elif item == '+' or item == '-':
            while stack and stack[-1] != '(':
                res+= stack.pop()
            stack.append(item)
        elif item == ')':
            while stack and stack[-1] != '(':
                res += stack.pop()
            stack.pop()

while stack :
    res += stack.pop()

print(res)
