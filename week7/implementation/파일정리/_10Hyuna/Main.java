package week7.implementation.파일정리._10Hyuna;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // TreeMap을 사용하면 키가 자동으로 정렬됨
        Map<String, Integer> extensionCount = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String filename = br.readLine();
            String extension = filename.substring(filename.lastIndexOf('.') + 1);

            extensionCount.put(extension, extensionCount.getOrDefault(extension, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : extensionCount.entrySet()) {
            sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        }

        System.out.print(sb);
    }
}
