import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class subi930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        boolean isValid = true;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
                valueStack.push(-1);
            } else {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }

                char open = stack.pop();
                int temp = 0;

                while (!valueStack.isEmpty() && valueStack.peek() != -1) {
                    temp += valueStack.pop();
                }

                if (valueStack.isEmpty()) {
                    isValid = false;
                    break;
                }

                valueStack.pop();

                if ((ch == ')' && open != '(') || (ch == ']' && open != '[')) {
                    isValid = false;
                    break;
                }

                int value = (ch == ')') ? 2 : 3;
                if (temp > 0) value *= temp;

                valueStack.push(value);
            }
        }

        if (!isValid || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            int result = 0;
            while (!valueStack.isEmpty()) {
                result += valueStack.pop();
            }
            System.out.println(result);
        }
    }
}
