package org.example.week1;

import java.io.*;
import java.util.Stack;

public class Q1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (Character.isAlphabetic(now)) {
                sb.append(now);
            } else if (now == '(') {
                stack.push(now);
            } else if (now == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                    sb.append(stack.pop());
                }
                stack.push(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    private static int priority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
                return 0;
        }
        return -1;
    }
}

