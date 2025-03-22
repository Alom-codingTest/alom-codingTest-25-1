import sys
a=input()
stack=[]
for i in range(len(a)):
  if a[i]=='(':
    stack.append(a[i])
  elif a[i]=='*' or a[i]=='/':
    while len(stack)!=0 and (stack[-1]=='*' or stack[-1]=='/'):
      print(stack.pop(),end="")
    stack.append(a[i])
  elif a[i]=='+' or a[i]=='-':
    while len(stack)!=0 and stack[-1]!="(":
      print(stack.pop(),end="")
    stack.append(a[i])
  elif a[i]==')':
    while stack[-1]!='(':
      print(stack.pop(), end="")
    stack.pop()
  else :
    print(a[i],end="")
while len(stack)!=0:
  print(stack.pop(),end="")
