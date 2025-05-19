package arom.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num2623 {

    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        size = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j < Integer.parseInt(input[0]); j++) {
                graph.get(Integer.parseInt(input[j])).add(Integer.parseInt(input[j+1]));
                size[Integer.parseInt(input[j+1])]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if(size[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            for (Integer i  : graph.get(current)) {
                size[i]--;
                if(size[i] == 0){
                    queue.offer(i);
                }
            }
        }

        if(result.size() == n){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(result.get(i)).append("\n");
            }
            System.out.println(sb.toString().trim());
        } else{
            System.out.println("0");
        }
    }
}
//20min