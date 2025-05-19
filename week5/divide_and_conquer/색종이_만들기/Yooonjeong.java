import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yooonjeong {
	private static int[][] arr;
	private static int[] count = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cutPaper(0, 0, n);
		System.out.println(count[0]+"\n"+count[1]);
	}

	public static void cutPaper(int y, int x, int len) {
		if(len == 1) {
			count[arr[y][x]]++;
			return;
		}
		
		int color = arr[y][x];
		boolean equal = true;
		outer:
		for(int i=y; i<y+len; i++) {
			for(int j=x; j<x+len; j++) {
				if(arr[i][j] != color) {
					equal = false;
					break outer;
				}
			}
		}
		if(equal) {
			count[arr[y][x]]++;
			return;
		}
		
		int newLen = len/2;
		cutPaper(y, x, newLen);
		cutPaper(y, x+newLen, newLen);
		cutPaper(y+newLen, x, newLen);
		cutPaper(y+newLen, x+newLen, newLen);
	}
}
