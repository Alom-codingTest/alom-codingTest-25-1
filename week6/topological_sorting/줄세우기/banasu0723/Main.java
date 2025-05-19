package topological_sorting.줄세우기.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1]; // 진입 차수
        // 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int A, B; // A가 B보다 키가 크다
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B); // A -> B
            inDegree[B]++; // B의 진입 차수 증가
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(inDegree[i] == 0){ // 진입 차수가 0인 노드
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current).append("\n");
            for(int next : graph.get(current)){
                inDegree[next]--; // 진입 차수 감소
                if(inDegree[next] == 0){ // 진입 차수가 0이 되면 큐에 추가
                    queue.add(next);
                }
            }
        }

        System.out.println(sb);

    }
}
