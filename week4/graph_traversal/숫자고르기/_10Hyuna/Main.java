package week4.graph_traversal.숫자고르기._10Hyuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static boolean[] check;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
            // 입력값을 0-based index로 맞추기 위해 -1
        }

        answer = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            check[i] = true;
            dfs(i, i);
            check[i] = false;
        }

        Collections.sort(answer);
        sb.append(answer.size()).append("\n");

        for (int i : answer) {
            sb.append(i + 1).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, int target) {
        if (!check[arr[start]]) {
            check[arr[start]] = true;
            dfs(arr[start], target);
            check[arr[start]] = false;
        }
        else if (arr[start] == target) {
            answer.add(target);
        }

    }

}
