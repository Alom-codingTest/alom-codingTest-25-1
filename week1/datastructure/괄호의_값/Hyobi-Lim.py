import sys
arr=sys.stdin.readline().strip()
arr=arr.replace('()','2')
arr=arr.replace('[]','3')
arr=list(arr)
parentheses=['(',')','[',']']
while(len(arr)!=1):
    for i in range(len(arr)-1):
        if arr[i] not in parentheses:
            if i!=0 and arr[i-1]=='(' and arr[i+1]==')':
                arr=arr[:i-1]+[int(arr[i])*2]+arr[i+2:]
                break
            elif i!=0 and arr[i-1]=='[' and arr[i+1]==']':
                arr=arr[:i-1]+[int(arr[i])*3]+arr[i+2:]
                break
            elif arr[i+1] not in parentheses:
                arr=arr[:i]+[int(arr[i])+int(arr[i+1])]+arr[i+2:]
                break
        if i==len(arr)-2:
            arr=[0]
if len(arr)==1 and arr[0] in parentheses:
    arr=[0]
print(arr[0])