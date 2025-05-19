//  동전 게임

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            String coins = "";
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    char coin = st.nextToken().charAt(0);
                    coins += coin;
                }
            }

            int min = bfs(coins);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(String start) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> que = new ArrayDeque<>();

        que.add(start);
        map.put(start, 0);

        while (!que.isEmpty()) {
            String curr = que.poll();
            int cnt = map.get(curr);

            if (isCompleted(curr)) {
                return cnt;
            }

            StringBuilder next = new StringBuilder(curr);
            for (int i = 0; i < 3; i++) {
                char coin = next.charAt(i);
                next.deleteCharAt(i);
                if (coin == 'H') {
                    next.insert(i, 'T');
                } else {
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1) {
                map.put(next.toString(), cnt + 1);
                que.add(next.toString());
            }

            next = new StringBuilder(curr);
            for (int i = 3; i < 6; i++) {
                char coin = next.charAt(i);
                next.deleteCharAt(i);
                if (coin == 'H') {
                    next.insert(i, 'T');
                } else {
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1) {
                map.put(next.toString(), cnt + 1);
                que.add(next.toString());
            }

            next = new StringBuilder(curr);
            for (int i = 6; i < 9; i++) {
                char coin = next.charAt(i);
                next.deleteCharAt(i);
                if (coin == 'H') {
                    next.insert(i, 'T');
                } else {
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1) {
                map.put(next.toString(), cnt + 1);
                que.add(next.toString());
            }

            next = new StringBuilder(curr);
            for (int i = 0; i < 9; i+=3) {
                char coin = next.charAt(i);
                next.deleteCharAt(i);
                if (coin == 'H') {
                    next.insert(i, 'T');
                } else {
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1) {
                map.put(next.toString(), cnt + 1);
                que.add(next.toString());
            }

            next = new StringBuilder(curr);
            for (int i = 1; i < 9; i+=3) {
                char coin = next.charAt(i);
                next.deleteCharAt(i);
                if (coin == 'H') {
                    next.insert(i, 'T');
                } else {
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1) {
                map.put(next.toString(), cnt + 1);
                que.add(next.toString());
            }

            next = new StringBuilder(curr);
            for (int i = 2; i < 9; i+=3) {
                char coin = next.charAt(i);
                next.deleteCharAt(i);
                if (coin == 'H') {
                    next.insert(i, 'T');
                } else {
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1) {
                map.put(next.toString(), cnt + 1);
                que.add(next.toString());
            }

            next = new StringBuilder(curr);
            for (int i = 0; i < 9; i+=4) {
                char coin = next.charAt(i);
                next.deleteCharAt(i);
                if (coin == 'H') {
                    next.insert(i, 'T');
                } else {
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1) {
                map.put(next.toString(), cnt + 1);
                que.add(next.toString());
            }

            next = new StringBuilder(curr);
            for (int i = 2; i < 7; i+=2) {
                char coin = next.charAt(i);
                next.deleteCharAt(i);
                if (coin == 'H') {
                    next.insert(i, 'T');
                } else {
                    next.insert(i, 'H');
                }
            }

            if (!map.containsKey(next.toString()) || map.get(next.toString()) > cnt + 1) {
                map.put(next.toString(), cnt + 1);
                que.add(next.toString());
            }
        }

        return -1;
    }

    static boolean isCompleted(String str) {
        char coin = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (coin != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
