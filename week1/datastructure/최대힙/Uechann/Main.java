package datastructure.최대힙.Uechann;

import java.io.*;
import java.util.*;

//30m
public class Main {
    public static void main(String[] args) throws IOException {
        int N, num;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            //입력받은 정수가 0이면 배열에 가장 큰값을 출력하고 그 값을 배열에서 제거하는 경우
            if(num == 0){
                if(pq.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(pq.poll()).append("\n");
                }
            }
            //입력받은 정수가 자연수이면 배열에 x를 추가하는 연산
            else {
                pq.add(num);
            }
        }
        System.out.println(sb);
    }
}
