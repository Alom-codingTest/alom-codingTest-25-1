import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String postfixExpression = br.readLine();

        Deque<Character> mainStack = new ArrayDeque<>();
        Deque<Character> subStack = new ArrayDeque<>();

        for (char ch : postfixExpression.toCharArray()) {
            switch (ch) {
                case '(':
                    subStack.push(ch);
                    break;
                case ')':
                    while (!subStack.isEmpty() && subStack.peek() != '(') {
                        mainStack.push(subStack.pop());
                    }
                    if (!subStack.isEmpty() && subStack.peek() == '(') subStack.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!subStack.isEmpty()) {
                        char top = subStack.peek();
                        if (top == '(') break;

                        // 스택 안에 있는게 우선순위가 더 높으면 안에있는걸 main에 넣는다
                        if ((ch == '+' || ch == '-') && (top == '*' || top == '/')) {
                            mainStack.push(subStack.pop());
                        } else if ((ch == '+' || ch == '-') && (top == '+' || top == '-')) {
                            mainStack.push(subStack.pop());
                        } else if ((ch == '*' || ch == '/') && (top == '*' || top == '/')) {
                            mainStack.push(subStack.pop());
                        } else {
                            break;
                        }
                    }
                    subStack.push(ch);
                    break;
                default:
                    mainStack.push(ch);
            }
        }

        while (!subStack.isEmpty()) {
            mainStack.push(subStack.pop());
        }

        while (!mainStack.isEmpty()) bw.write(mainStack.pollLast());

        bw.flush();
        bw.close();
    }
}