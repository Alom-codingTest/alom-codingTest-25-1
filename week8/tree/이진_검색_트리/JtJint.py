import sys
sys.setrecursionlimit(10**6)

preorder = []
for line in sys.stdin:
    preorder.append(int(line))

output = []

def build_postorder(start, end):
    if start > end:
        return

    root = preorder[start]
    idx = start + 1
    while idx <= end and preorder[idx] < root:
        idx += 1

    build_postorder(start + 1, idx - 1)
    build_postorder(idx, end)

    output.append(str(root))

build_postorder(0, len(preorder) - 1)

sys.stdout.write('\n'.join(output) + '\n')
