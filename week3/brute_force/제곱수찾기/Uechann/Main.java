package brute_force.제곱수찾기.Uechann;

//N행 M열의 표 A가 있고, 표 각 칸에는 숫자가 적혀있다.
//서로 다른 1개 이상의 칸을 선택하려고 하는데,
//행은 선택한 순서대로 등차수열, 열도 선태간 순서대로 등차수열을 이루고 있어야 한다.
//이렇게 선택한 칸에 적힌 수를 순서대로 이어붙이면 정수 하나를 만든다.
//->>>> 만들 수 있는 정수 중에서 가장 큰 완전 제곱수를 찾기

//입력
//N M이 주어진다.
//둘째 줄부터 N개의 줄에는 표에 적힌 숫자가 1번 행부터 N번 행까지 순서대로 한 줄에 한 행씩 주어진다.

//출력
//연두가 만들 수 있는 가장 큰 완전 제곱수를 출력한다.
//완전 제곱수를 만들 수 없으면 -1 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean isSquare(int n) {
        if (Math.sqrt(n) % 1 == 0) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        int[][] nums;
        int result = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = br.readLine();
        st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine();
            for (int j = 1; j <= M; j++) {
                nums[i][j] = Integer.parseInt(input.split("")[j - 1]);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int di = -N; di <= N; di++) {  //행 i의 등차는 -N ~ +N 까지 반복
                    for (int dj = -M; dj <= M; dj++) {  //열 j의 등차는 -M ~ +M 까지 반복
                        if(di == 0 && dj == 0) continue; //등차가 모두 0일때 무시

                        int newI = i;
                        int newJ = j;
                        int now = 0;
                        while (newI >= 1 && newI <= N && newJ >= 1 && newJ <= M) {
                            now *= 10;
                            now += nums[newI][newJ];

                            if (isSquare(now)) result = Math.max(result, now);

                            newI += di;
                            newJ += dj;
                        }
                    }
                }
            }
        }
        System.out.print(result);
    }
}
