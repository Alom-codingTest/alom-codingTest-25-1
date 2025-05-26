import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 9)

class Node:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None

class Tree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        node = Node(data)
        parent = None
        current = self.root

        while current:
            parent = current
            if node.data < current.data:
                current = current.left
            else:
                current = current.right

        if parent is None:
            self.root = node
        elif node.data < parent.data:
            parent.left = node
        else:
            parent.right = node

    def postorder(self, node):
        if node:
            self.postorder(node.left)
            self.postorder(node.right)
            print(node.data)

tree = Tree()
while True:
    val = input().rstrip()
    if not val:
        break
    tree.insert(int(val))

tree.postorder(tree.root)
