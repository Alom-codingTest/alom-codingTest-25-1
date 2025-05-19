import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yooonjeong {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(pooling(n, arr));
	}

	public static int pooling(int n, int[][] arr) {
		if(n==1) return arr[0][0];
		int[][] newArr = new int[n/2][n/2];
		for(int i=0; i<n; i+=2) {
			for(int j=0; j<n; j+=2) {
				newArr[i/2][j/2] = findSecond(arr[i][j], arr[i][j+1], arr[i+1][j], arr[i+1][j+1]);
			}
		}
		return pooling(n/2, newArr);
	}
	
	public static int findSecond(int a, int b, int c, int d) {
		int max = Math.max(Math.max(a, b), Math.max(c, d));
		if(a == max) return Math.max(Math.max(b, c), d);
		if(b == max) return Math.max(Math.max(a, c), d);
		if(c == max) return Math.max(Math.max(a, b), d);
		return Math.max(Math.max(a, b), c);
	}
}
