package arom.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Num2447 {

    static int n;
    static char[][] result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = new char[n][n];

        recursive(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.print(sb);
    }

    static void recursive(int x, int y, int size) {
        if(size == 1){
            result[x][y] = '*';
        } else{
            size = size/3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == 1 && j == 1) {
                      blank(x+size, y+size, size);
                    } else{
                        recursive(x + size*i , y + size*j, size);
                    }
                }
            }
        }
    }

    static void blank(int x, int y, int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size; j++) {
                result[x+i][y+j] = ' ';
            }
        }
    }

}
