import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) sb.append("-1\n");
                else sb.append(queue.pollFirst()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? "1\n" : "0\n");
            } else if (command.equals("front")) {
                if (queue.isEmpty()) sb.append("-1\n");
                else sb.append(queue.peekFirst()).append("\n");
            } else if (command.equals("back")) {
                if (queue.isEmpty()) sb.append("-1\n");
                else sb.append(queue.peekLast()).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}