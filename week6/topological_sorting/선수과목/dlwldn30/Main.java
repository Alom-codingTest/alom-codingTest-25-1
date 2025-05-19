package 선수과목.dlwldn30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 과목 수
        int m = Integer.parseInt(st.nextToken()); // 선수 조건 수

        int[] degree = new int[n+1]; // 선수 과목들 수
        int[] semester = new int[n+1];

        List<List<Integer>> array = new ArrayList<List<Integer>>();
        for (int i = 0; i <=n; i++) {
            array.add(new ArrayList<>());
        }

        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array.get(a).add(b);
            degree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();


        //선수 과목 없는 것들
        for (int i = 1; i<= n; i++){
            if (degree[i] == 0){
                queue.add(i);
                semester[i] = 1;
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.poll(); // 선수과목에서 처음부터 차근차근
            for (int i : array.get(cur)){ // 얘랑 연결된 과목
                degree[i]--;
                if (semester[i] <= semester[cur]){
                    semester[i] = semester[cur]+1;
                }
                if(degree[i] == 0){
                    queue.add(i);
                }
            }
        }
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(semester[i]).append(" ");
        }

        System.out.println(sb.toString());

    }


}
