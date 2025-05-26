package implementation.파일정리.Uechann;
/*

문제
파일들을 잘 분석해서 보물의 주인공이 될 수 있길 바랄게. 힌트는 “확장자”야.

파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
보기 편하게 확장자들을 사전 순으로 정렬해 줘
그럼 보물의 절반을 얻어내기 위해 얼른 스브러스의 노트북 파일 정리를 해줄 프로그램을 만들자!

입력
첫째 줄에 바탕화면에 있는 파일의 개수
N이 주어진다. (1 <= N <= 50,000)

둘째 줄부터
N개 줄에 바탕화면에 있는 파일의 이름이 주어진다. 파일의 이름은 알파벳 소문자와 점(.)으로만 구성되어 있다.
점은 정확히 한 번 등장하며, 파일 이름의 첫 글자 또는 마지막 글자로 오지 않는다. 각 파일의 이름의 길이는 최소3, 최대 100이다.

출력
확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력한다. 확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<String, Integer> result = new TreeMap<>(); // 확장자와 개수를 저장할 TreeMap

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            // 파일 이름에서 확장자 추출
            String fileName = st.nextToken();
            String extension = st.nextToken();
            result.put(extension, result.getOrDefault(extension, 0) + 1);
        }

        // 확장자와 개수를 출력
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.print(sb);
    }
}
