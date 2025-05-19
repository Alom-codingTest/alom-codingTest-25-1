import java.io.*;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) return Integer.compare(a, b);
            else return Integer.compare(Math.abs(a), Math.abs(b));
        });

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value != 0) {
                heap.add(value);
            } else {
                if (heap.isEmpty()) bw.write(0 + "\n");
                else bw.write(heap.poll() + "\n");
            }
        }

        bw.flush();
    }
}