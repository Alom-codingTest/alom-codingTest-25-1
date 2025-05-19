import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hyeblee{
	public static int[] arr;
	public static int[] dp;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Arrays.fill(dp, 1);
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					// dp[i]와 dp[j]+1 중 더 큰 값으로 dp 갱신
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}

		int max = 0;
		for(int elem: dp) {
			max = Math.max(elem, max);
		}
		System.out.println(max);
		
	}
}