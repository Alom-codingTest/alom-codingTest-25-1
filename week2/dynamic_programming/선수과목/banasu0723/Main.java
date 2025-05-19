package dynamic_programming.선수과목.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 일단 배열로 N개의 과목에 1씩 저장
        // 선수과목 순으로 줄을 세우기
        // 1 2,3,4 5
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 과목의 수
        int M = Integer.parseInt(st.nextToken()); // 선수 과목의 수
        int[] subjects = new int[N+1]; // 들어야 되는 과목 순서별로 정룔
        int[] cnt = new int[N+1]; // N개의 각 과목에 대한 이수하기 위한 최소 학기
        int first, next; // first < next 과목

        // 최소 1학기이므로
        for(int i=1; i<N+1; i++){
            cnt[i] = 1;
        }

        // 들어야 되는 과목 순으로 나열
        for(int i=1; i<M+1; i++){
            first = Integer.parseInt(st.nextToken());
            next = Integer.parseInt(st.nextToken());
            subjects[next-1]++; // 0 ~ N-1 까지 이므로 한개씩 땡겨줘야됌
        }

        for(int i=1; i<N+1; i++){
            System.out.print(subjects[i] + " ");
        }




    }
}
