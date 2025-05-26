package implementation.파일정리.banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        // 확장자별 파일개수를 저장할 맵
        Map<String, Integer> fileCount = new HashMap<>();

        for(int i=0 ; i<N; i++){
            StringTokenizer fileToken = new StringTokenizer(br.readLine(), ".");
            fileToken.nextToken(); // 파일 이름은 필요 없으므로 무시
            String fileExtension = fileToken.nextToken();

            // fileExtension과 같은게 있으면 거기다 1 더하기, 아니면 0 에다가 1 더하기
            fileCount.put(fileExtension, fileCount.getOrDefault(fileExtension, 0)+1);
        }

        // 사전순으로 정렬
        List<String> sortedExtensions = new ArrayList<>(fileCount.keySet());
        Collections.sort(sortedExtensions);

        for(String extension : sortedExtensions){
            sb.append(extension).append(" ").append(fileCount.get(extension)).append("\n");
        }

        System.out.print(sb);
    }
}
