import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yooonjeong {
	private static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		printStar(n, 0, 0);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	
	public static void printStar(int n, int y, int x) {
		if(n==1) {
			arr[y][x] = '*';
			return;
		}
		int boxLen = n/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) {
					printBlank(boxLen, y+i*boxLen, x+j*boxLen);
				}
				else {
					printStar(boxLen, y+i*boxLen, x+j*boxLen);
				}
			}
		}
	}
	
	public static void printBlank(int n, int y, int x) {
		for(int i=y; i<y+n; i++) {
			for(int j=x; j<x+n; j++) {
				arr[i][j] = ' ';
			}
		}
	}
	
}
