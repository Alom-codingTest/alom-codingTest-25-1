package week1.datastructure.최대힙._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int count = Integer.parseInt(br.readLine());
        Integer item;

        for (int i = 0; i < count; i++) {
            item = Integer.parseInt(br.readLine());

            if(item == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.offer(item);
            }
        }

        System.out.println(sb);
    }

}
