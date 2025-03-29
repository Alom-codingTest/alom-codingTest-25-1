import sys
input = sys.stdin.readline



def function(str1, str2):
    if len(str2) > 0 :
        if len(str1) == len(str2) :
            if str1 == str2 :
                print(1)
                exit(0)
    
        if str2[-1] == 'A' :
            function(str1, str2[:-1])
        if str2[0] == 'B' :
            function(str1, str2[1:][::-1])

str1 = input().strip()


str2 = input().strip()

function(str1, str2)
print(0)
