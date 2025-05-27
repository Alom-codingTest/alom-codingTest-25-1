package week7.implementation.단어뒤집기2._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        boolean inTag = false;

        for (char c : input.toCharArray()) {
            if (c == '<') {
                // 스택 비우기 (단어 뒤집기)
                inTag = true;
                sb.append(c);
            } else if (c == '>') {
                inTag = false;
                sb.append(c);
            } else if (inTag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }

        // 마지막 단어 처리
        System.out.println(sb.toString());
    }

}
