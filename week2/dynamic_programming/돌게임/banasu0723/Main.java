package dynamic_programming.돌게임.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int winner = 0;
        while(N!=0){
            if(N>3){
                N-=3;
            }else{
                N--;
            }
            winner++;
        }
        if(winner%2==0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }
}