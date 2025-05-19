package org.example.week2;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            bw.write(combination(m, n) + "\n");
        }
        bw.flush();
    }

    private static BigInteger combination(int m, int n) {
        BigInteger numerator = factorial(m);
        BigInteger denominator = factorial(n).multiply(factorial(m - n));

        return numerator.divide(denominator);
    }

    private static BigInteger factorial(int num) {
        if (num == 0 || num == 1) {
            return BigInteger.ONE;
        } else {
            return factorial(num - 1).multiply(BigInteger.valueOf(num));
        }
    }
}
