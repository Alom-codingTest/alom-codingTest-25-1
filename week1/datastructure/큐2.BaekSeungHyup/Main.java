## 큐 2 
class Queue:
    def __init__(self):
        self.queue=[]

    def push(self,X):
        self.queue.append(X)
        return self.queue[-1]

    def pop(self): ## 가장 앞에 있는 정수를 빼고 출력
        if self.queue: ## 큐 안에 원소가 존재할때
            return self.queue.pop(0)
        return -1

    def size(self):
        return len(self.queue)
    
    def empty(self):
        if not self.queue:
            return 1
        else:
            return 0
    
    def front(self):
        if self.queue:
            return self.queue[0]
        else:
            return -1
    
    def back(self):
        if self.queue:
            return self.queue[-1]
        else:
            return -1


def commands(q,command):
    command_list=command.split()
    cmd=command_list[0]

    if(cmd=="push"):
        element=int(command_list[1])
        q.push(element)
    
    elif(cmd=="pop"):
        result=q.pop()
        print(result)
    
    elif(cmd=="size"):
        result=q.size()
        print(result)
    
    elif(cmd=="empty"):
        result=q.empty()
        print(result)
    
    elif(cmd=="front"):
        result=q.front()
        print(result)
    elif(cmd=="back"):
        result=q.back()
        print(result)


## main 시작
q=Queue()
N=int(input())

for i in range(N):
    command=input()
    commands(q,command)  

