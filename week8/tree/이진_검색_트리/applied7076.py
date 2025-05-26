import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

class Node:
    def __init__(self, val):
        self.val   = val
        self.left  = None
        self.right = None

def insert(node, val):
    if node is None:
        return Node(val)
    
    if val < node.val:
        node.left  = insert(node.left, val)
    else:
        node.right = insert(node.right, val)
    
    return node

def build(pre):
    root = None
    for val in pre:
        root = insert(root, val)

    return root

def postorder(node):
    if node:
        postorder(node.left)
        postorder(node.right)
        print(node.val)

pre = []
while True:
    try:
        x = input().strip()
        if not x: break

        pre.append(int(x))
    except:
        break

root = build(pre)
postorder(root)