import java.util.*;
import java.io.*;

public class Hyeblee {
	 
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
 
	
	public static void dfs(int start, int depth) {
		if(depth == M) { // 길이 M 만들면 탈출
			for(int val: arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			arr[depth] = i;
			dfs(i+1,depth+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
 
		arr = new int[M];
        
		dfs(1,0);
		System.out.println(sb);
	}
 }