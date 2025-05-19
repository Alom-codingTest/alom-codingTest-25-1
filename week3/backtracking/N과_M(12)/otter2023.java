import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 문제 특징 : 같은 숫자를 여러번 사용할 수 있어서 상태 복구가 필요없음

public class Main {

    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<Integer, Boolean> arr;
    static int[] sequence;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new TreeMap<>();
        sequence = new int[m];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            arr.put(key, true);
        }
        backTrack(0);

        bw.flush();
        bw.close();
    }

    static void backTrack(int depth) throws IOException {

        if (depth == m) { // 종료조건
            for (int num : sequence) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (Map.Entry<Integer, Boolean> entry : arr.entrySet()) { // 현재 깊이에서 가능한 모든 선택을 탐색
            if (entry.getValue()) {
                if (depth > 0 && sequence[depth - 1] > entry.getKey()) continue; // 탐색 범위 축소 -> 백트래킹
                sequence[depth] = entry.getKey();
                backTrack(depth + 1); // 다음 깊이로 이동
            }
        }
    }

}