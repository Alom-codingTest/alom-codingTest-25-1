package implementation.단어뒤집기2.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean inTag = false; // <태그> 안에 있는지 여부

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '<') {
                inTag = true; // 태그 시작
                while (!stack.isEmpty()) {
                    result.append(stack.pop()); // 스택에 쌓인 문자들을 뒤집어서 출력
                }
                result.append(ch); // '<' 출력
            } else if (ch == '>') {
                result.append(ch); // '>' 출력
                inTag = false; // 태그 종료
            } else if (inTag) {
                result.append(ch); // 태그 안의 문자 그대로 출력
            } else {
                if(ch == ' '){
                    while(!stack.isEmpty()){
                        result.append(stack.pop()); // 스택에 쌓인 문자들을 뒤집어서 출력
                    }
                    result.append(' '); // 공백은 그대로 출력
                }else{
                    stack.push(ch); // 태그 밖의 문자는 스택에 쌓기
                }
            }
        }

        // 스택에 남아있는 문자들을 뒤집어서 출력
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        // 최종 결과 출력
        System.out.println(result);
    }
}
