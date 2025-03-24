package datastructure.스택.Uechann;

import java.io.*;
import java.util.*;

//10m
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            //push 정수 X를 스택에 넣는 연산
            if(input.contains("push")){
                int num = Integer.parseInt(input.split(" ")[1]);
                stack.push(num);
            }
            //pop 스택에서 가장 위에 있는 정수를 빼고 그 수를 출력
            //없는 경우는 -1 출력
            else if(input.equals("pop")){
                try {
                    int num = stack.pop();
                    sb.append(num).append("\n");
                }catch (EmptyStackException e){
                    sb.append(-1).append("\n");
                }
            }
            //size 스택에 들어있는 정수의 개수를 출력
            else if(input.equals("size")){
                sb.append(stack.size()).append("\n");
            }
            //empty 스택이 비어있으면1 아니면 0을 출력
            else if(input.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            }
            //top 스택의 가장 위에 있는 정수를 출력한다.
            //스택에 정수가 없는 경우에는 -1 출력
            else if(input.equals("top")) {
                if(stack.isEmpty()) {
                    sb.append(-1).append("\n");
                }else{
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}