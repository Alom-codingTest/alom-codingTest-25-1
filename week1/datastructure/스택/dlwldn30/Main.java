package datastructure.스택.dlwldn30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>(); // 스택 선언
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine()); // br을 받을 int 선언

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // Stack에 문자와 숫자를 나눠주어야 하기 때문
            String str = st.nextToken();

            if (str.equals("push")) { // push를 입력받는다면
                stack.push(Integer.parseInt(st.nextToken()));
            }
            if (str.equals("pop")) { // pop를 입력받는다면
                sb.append(stack.isEmpty() ? sb.append(-1 + "/n") : sb.append(stack.pop() + "/n"));
            }
            if (str.equals("size")) { // size를 입력받는다면
                sb.append(stack.size() + "\n");
            }
            if (str.equals("empty")) { // empty를 입력받는다면
                sb.append(stack.isEmpty() ? sb.append(1 + "\n") : sb.append(0 + "\n"));
            }
            if (str.equals("top")) { // top를 입력받는다면
                sb.append(stack.isEmpty() ? sb.append(-1 + "\n") : sb.append(stack.peek() + "\n"));

            }
        }
        System.out.println(sb);
    }
}
