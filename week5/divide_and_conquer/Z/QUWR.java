package arom.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1074 {

    static int n;
    static int r;
    static int c;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        recursive(0, 0, 1<<n);


    }

    static void recursive(int x, int y, int size){
        int half = size/2;
        if(x == r && y == c){
            System.out.println(count);
            return;
        }
        if(r < x + half && c < y + half){
            recursive(x, y, half);
        } else if(r < x + half){
            count+= half*half;
            recursive(x, y + half, half);
        } else if(c < y + half){
            count += half * half * 2;
            recursive(x + half, y, half);
        } else{
            count += half * half * 3;
            recursive(x + half, y + half, half);
        }
    }
}
//40min