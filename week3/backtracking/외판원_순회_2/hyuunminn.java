//  외판원 순회 2

import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    static int n;
    static int arr[][];
    static boolean visited[];
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[1] = true;
        back(1, 1, 1, 0);
        System.out.println(res);
    }

    static void back(int start, int now, int count, int cost) {
        if(arr[now][start] != 0 && count == n) {
            res = Math.min(res, cost + arr[now][start]);
            return;
        }

        for (int next = 1; next <= n; next++) {
            if(arr[now][next] > 0 && !visited[next]) {
                visited[next] = true;
                back(start, next, count + 1, cost + arr[now][next]);
                visited[next] = false;
            }
        }
    }
}
