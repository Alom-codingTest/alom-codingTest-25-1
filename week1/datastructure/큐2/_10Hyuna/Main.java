package week1.datastructure.큐2._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        StringTokenizer command;

        int count = Integer.parseInt(br.readLine());
        int back = 0;

        for (int i = 0; i < count; i++) {
            command = new StringTokenizer(br.readLine());

            switch (command.nextToken()) {
                case "push":
                    int item = Integer.parseInt(command.nextToken());
                    q.add(item);
                    back = item;
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : back).append("\n");
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}
