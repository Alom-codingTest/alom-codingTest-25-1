s = input()
t = input()
queue = [t]

# S -> T: +A, or +B (reverse)
# T -> S: 맨 끝에서 -A, 맨 앞에서 -B 후 reverse

while queue:
    now = queue.pop(0)

    if now == s:
        print(1)
        break

    if len(now) < len(s):
        continue

    if now[-1] == 'A':
        queue.append(now[:-1])
    if now[0] == 'B':
        queue.append(now[1:][::-1])
else:
    print(0)