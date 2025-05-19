package dynamic_programming.돌게임.Uechann;

import java.io.*;

//20M
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_num = Integer.parseInt(br.readLine());
        //순서 : 상근1 창영2
        //돌은 1개 또는 3개
        //홀수일때 상근 승, 짝수일때 찬영 승
        //1 1, 3 3, 1 3, 3, 1 모두 더했을 때 짝수이므로
        //선인 상근이 홀수일때 승, 후선인 찬영은 짝수일때 승
        int winner = total_num % 2 == 1? 1 : 2;
        System.out.print(winner == 1 ? "SK" : "CY");
    }
}