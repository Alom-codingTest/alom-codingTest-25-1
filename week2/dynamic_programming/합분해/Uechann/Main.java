package dynamic_programming.합분해.Uechann;

import java.util.*;
import java.io.*;

//1H
public class Main {
    static long[][] array;
    static long NdivideKCount(int N, int K) {
        //System.out.println("여기는 N: " + N + " K: " + K);
        if(array[N][K] > 0) return array[N][K];
        if (N == 0 || K == 1) return array[N][K] = 1;

        for (int i = N; i >= 0; i--) {
            array[N][K] += NdivideKCount(i, K - 1);
            array[N][K] %= 1000000000;
            //System.out.println("array[" + N + "]" + "[" + K + "] : " + array[N][K]);
        }
        return array[N][K];
    }

    public static void main(String[] args) throws IOException {
        //0 부터 N까지의 정수 k개를 더해서 그 합이 N이 되는 경우의 수
        //순서가 바뀌는 경우도 별도로 계산
        //한개의 수를 여러번 계산 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        array = new long[N + 1][K + 1];
        System.out.print(NdivideKCount(N, K) % 1000000000);
    }
}
