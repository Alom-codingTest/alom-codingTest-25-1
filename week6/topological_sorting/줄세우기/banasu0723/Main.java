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
        List<List<Integer>> graph = new ArrayList<>(); // 인접 리스트, graph.get(A)는 A 다음에 와야 하는 학생들의 리스트
        int[] inDegree = new int[N + 1]; // 진입 차수, inDegree[i]는 학생 i 앞에 와야 하는 학생 수
        // 초기화, 1번 학생부터 N번 학생까지 사용할 수 있도록 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int A, B; // A가 B보다 키가 크다
        // 비교 관계를 입력 받아 그래프를 구성하고 진입 차수를 업데이트
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B); // A가 B 앞에 서야 한다
            inDegree[B]++; // B의 진입 차수 증가, B의 앞에 올 학생이 한 명 증가
        }

        // 진입 차수가 0인 학생(앞에 아무도 없어도 되는 학생들)을 큐에 넣는다
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(inDegree[i] == 0){ // 진입 차수가 0인 노드
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current).append("\n"); //현재 줄 세운 학생을 출력
            // 현재 학생보다 키가 작은 학생들(현재 학생 다음에 와야 하는 학생들)의 진입 차수를 감소시킨다
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
