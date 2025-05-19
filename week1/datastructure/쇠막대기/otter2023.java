import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

//week1\datastructure\스택\otter2023.java"

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String bar = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();

        boolean left = true;
        int cnt = 0;

        for (char x : bar.toCharArray()) {

            if (x == '(') {
                stack.push(x);
                left = true;
            } else {
                stack.pop();

                if (left) {
                    cnt += stack.size();
                } else {
                    cnt++;
                }
                left = false;
            }

        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}