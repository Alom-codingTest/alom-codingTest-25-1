import sys
S = sys.stdin.readline().strip() + ' ' # 마지막에 공백 더하기
stack = []
result = ''
cnt = 0 # 괄호 안에 있는지 여부
for i in S :
    if i == '<' : # <를 만나면
        cnt = 1 # 지금 괄호 안에 있음 표시
        for _ in range(len(stack)): #괄호 만나기 이전 stack 비우고 다 뒤집어서 더하기
            result += stack.pop()
    stack.append(i)
    
    if i == '>' : # >를 만나면
        cnt = 0 # 지금 괄호 빠져 나왔음 표시
        for _ in range(len(stack)): # 괄호 안에 있는 애들은 뒤집지 않고 더하기
            result += stack.pop(0)

    if i == ' ' and cnt == 0: # 공백을 만나고 괄호 밖에 있다면
        stack.pop() # 공백 빼기
        for _ in range(len(stack)): # 뒤집어서 더하기
            result += stack.pop()
        result += ' '
print(result)