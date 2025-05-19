package datastructure.큐2.naturalSy;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, back = 0, num;
        //queue 메소드
        //add 와 offer
        //remove와 poll
        //element와 peak
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            //push 명령어
            if(input.contains("push")) {
                back = Integer.parseInt(input.split(" ")[1]);
                queue.add(back);
            }//pop 가장 앞에 있는 정수 빼고 출력, 없으면 -1 출력
            else if(input.equals("pop")) {
                try {
                    num = queue.remove();
                    sb.append(num).append("\n");
                    //비어있으면 back에 저장되어 있는 수 0으로 초기화
                    if(queue.isEmpty()) {
                        back = 0;
                    }
                } catch (NoSuchElementException e) {
                    sb.append(-1).append("\n");
                }
            }//size 큐에 들어있는 정수 개수 출력
            else if(input.equals("size")) {
                sb.append(queue.size()).append("\n");
            }//empty 비어 있으면 1 아니면 0 출력
            else if(input.equals("empty")) {
                if(queue.isEmpty()) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }//front 가장 앞에 있는 정수 출력 없으면 -1
            else if(input.equals("front")) {
                if(queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }else{
                    sb.append(queue.peek()).append("\n");
                }
            }//back 가장 뒤에 있는 정수 출력 없으면 -1
            else if(input.equals("back")) {
                if(back != 0) {
                    sb.append(back).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
