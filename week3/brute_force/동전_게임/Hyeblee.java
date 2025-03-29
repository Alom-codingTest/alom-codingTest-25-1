import java.io.*;
import java.util.*;

public class Hyeblee {
	// 뒤집을 위치
	public static int[][] flips = {
			{0,1,2}, {3,4,5}, {6,7,8}, // 행 뒤집기
			{0,3,6}, {1,4,7}, {2,5,8}, // 열 뒤집기
			{0,4,8}, {2,4,6}, // 대각선 뒤집기
	};
	
	// 뒤집는 연산하는 메서드
	public static String operation(String str, int[] pos) {
		char[] arr = str.toCharArray();
		for(int idx: pos) {
			arr[idx] = (arr[idx]=='T')? 'H':'T';
		}
		return new String(arr);
	}
	
	public static int bfs(String start) {
		Queue<String> queue = new ArrayDeque<>();
		// key: 연산한 문자열, value: 연산 횟수
		Map<String,Integer> visited = new HashMap<>();
		queue.offer(start);
		visited.put(start, 0);
		
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			int cnt = visited.get(cur);
			
			if(cur.equals("HHHHHHHHH")||cur.equals("TTTTTTTTT")) {
				return cnt; // 전부 같으면 연산횟수 반환 후 종료
			}
			
			// 아니라면 8가지 연산 수행한 결과 큐에 저장
			// (단, 이미 있는 결과일 경우 최소횟수로 도달했을 경우에만 저장)
			for(int i=0;i<8;i++) {
				String next = operation(cur,flips[i]);
				if(!visited.containsKey(next) || visited.get(next)>cnt+1) {
					queue.offer(next);
					visited.put(next, cnt+1);
				}
			}
		}
		
		// 같은 경우 없으면 -1
		return -1;
	}

    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
        
        for(int i=0;i<T;i++) {
        	char[] ch = new char[9];
        	for(int j=0;j<9;j++) {
        		ch[j] = sc.next().charAt(0);
        	}
        	System.out.println(bfs(new String(ch)));
        }
    }
}
