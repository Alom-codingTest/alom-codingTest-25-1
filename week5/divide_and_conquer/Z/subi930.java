import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 복잡도 : O(N)
 */
public class subi930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(moveZ(N, r, c)); // 2^N * 2^N 배열에서 (r,c)를 방문하는 순서
    }

    private static int moveZ(int n, int rIdx, int cIdx) {
        if(n == 0) return 0;
        int half = (int) Math.pow(2, n - 1); // 사각형 한 변의 길이
        // (rIdx, cIdx) 위치별
        // 좌상
        if(rIdx < half && cIdx < half) return moveZ(n - 1, rIdx, cIdx);
        // 우상
        if(rIdx < half && cIdx >= half) return half * half + moveZ(n - 1, rIdx, cIdx - half);
        // 좌하
        if(rIdx >= half && cIdx < half) return 2 * half * half + moveZ(n - 1, rIdx - half, cIdx);
        // 우하
        return 3 * half * half + moveZ(n - 1, rIdx - half, cIdx - half);
    }
}