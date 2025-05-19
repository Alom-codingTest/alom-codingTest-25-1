package datastructure.최대힙.naturalSy;

import java.io.IOException;
import java.util.*;

// 최대힙은 우선순위 큐 자료구조를 사용
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x;
        // 우선 순위 큐 - 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder(); // StringBuilder 객체 생성 - 이걸로 출력하면 성능 향상

        for(int i=0; i<N; i++){
            x = sc.nextInt();
            if(x>0){
                pq.offer(x);
            }else if(x==0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}