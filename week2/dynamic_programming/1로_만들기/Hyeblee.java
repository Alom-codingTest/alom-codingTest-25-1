import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hyeblee{
	public static int[] result = new int[1000001];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		result[1] = 0;
		result[2] = 1;
		result[3] = 1;
		
		for(int i = 4;i<=1000000;i++) {
			result[i] = result[i-1]+1;
			if(i%3==0) {
				result[i] = Math.min(result[i], result[i/3]+1);
			}
			if(i%2==0) {
				result[i] = Math.min(result[i], result[i/2]+1);
			}
		}
		
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(result[n]);
		
	}
}