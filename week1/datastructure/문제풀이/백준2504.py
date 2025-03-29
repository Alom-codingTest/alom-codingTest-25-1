import sys
input = sys.stdin.readline

str1 = input().strip()

stack = []
error = 0 
for i in range(len(str1)) :
    if error == 1 :
        break
    if str1[i] == '[' or str1[i] == '(' :
        stack.append(str1[i])
    
    else :
        value = 1
        while str1[i] ==')' or str1[i] == ']' :
            if len(stack) == 0 :
                error = 1 
                break
            strTmp = stack.pop()
            if str1[i] == ')' and strTmp == '(' :
                stack.append(value*2)
                break
            elif str1[i] == ')' and strTmp == '[' :
                error = 1
                break
            elif str1[i] == ')' and strTmp != '(' and strTmp != '[' :
                if value == 1 :
                    tmpValue = int(strTmp)
                    value *= tmpValue
                else :
                    tmpValue = int(strTmp)
                    value += tmpValue
            if str1[i] == ']' and strTmp == '[' :
                stack.append(value*3)
                break
            elif str1[i] == ']' and strTmp == '(' :
                error = 1
                break
            elif str1[i] == ']' and strTmp!= '['  and strTmp != '(':
                if value == 1 :
                    tmpValue = int(strTmp)
                    value *= tmpValue
                else :
                    tmpValue = int(strTmp)
                    value += tmpValue
                

        
if '(' in stack or '[' in stack :
    error = 1    
                
if error == 1 :
    print(0)
else :
    print(sum(stack))
    
    