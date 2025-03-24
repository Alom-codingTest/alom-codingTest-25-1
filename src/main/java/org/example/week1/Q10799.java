package org.example.week1;

import java.io.*;
import java.util.Stack;

public class Q10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    stack.pop();
                    if(input.charAt(i-1)=='('){
                        sum+=stack.size();
                    }
                    else{
                        sum++;
                    }
                    break;
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
