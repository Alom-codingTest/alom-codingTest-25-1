package datastructure.큐2.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // IOEception 은 BufferedReader 을 사용할 때 발생할 수 있는 예외 처리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령의 수 입력받고 정수로 변환
        Queue<Integer> que = new LinkedList<Integer>(); // Queue 객체 생성
        StringBuilder sb = new StringBuilder(); // StringBuilder 객체 생성 - 이걸로 출력하면 성능 향상

        for(int i=0; i<N; i++){ //
            StringTokenizer st = new StringTokenizer(br.readLine()); // 입력을 받고 공백 기준으로 문자열을 나눠줌
            String S = st.nextToken();

            switch(S){
                case "push":
                    que.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(que.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(que.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    if(que.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(que.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(que.peek()).append("\n");
                    }
                    break;
                default:
                    if(que.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(((LinkedList<Integer>) que).peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
