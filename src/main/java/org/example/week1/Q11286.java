package org.example.week1;

import java.io.*;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> {
            int abs1 = Math.abs(n1);
            int abs2 = Math.abs(n2);

            return abs1 == abs2 ? Integer.compare(n1, n2) : Integer.compare(abs1, abs2);
        });

        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (priorityQueue.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(priorityQueue.poll() + "\n");
                }
            } else {
                priorityQueue.add(n);
            }
        }

        bw.flush();
    }
}

