package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Num2504 {

    public static void main(String[] args) throws IOException {

        Deque<Character> stack = new ArrayDeque<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        char[] string = input.toCharArray();

        int result = 0;
        int temp = 1;
        char prev = ' ';

        for (char c : string) {
            if (c == '(') {
                temp *= 2;
                stack.add(c);
            } else if (c == '[') {
                temp *= 3;
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pollLast() != '(') {
                    System.out.println("0");
                    return;
                }
                if (prev == '(') {
                    result += temp;
                }
                temp /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pollLast() != '[') {
                    System.out.println("0");
                    return;
                }
                if (prev == '[') {
                    result += temp;
                }
                temp /= 3;
            }
            prev = c;
        }

        if (!stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(result);
        }
    }
}
