import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Point{
	int x, y;
	Point(int y, int x){
		this.y = y;
		this.x = x;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Point point = (Point) obj;
		return this.y==point.y && this.x==point.x;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}

public class Yooonjeong {
	private static Set<Point> walls = new HashSet<>();
	private static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1, 0};
	private static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<8; i++) {
			String in = br.readLine();
			for(int j=0; j<8; j++) {
				if(in.charAt(j)=='#') {
					walls.add(new Point(i, j));
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static boolean range(int y, int x) {
		return y>=0 && y<8 && x>=0 && x<8;
	}
	
	private static void moveWalls() {
		Iterator<Point> iter = walls.iterator();
		List<Point> toAdd = new ArrayList<>();
		
		while(iter.hasNext()) {
			Point wall = iter.next();
			int newY = wall.y+1;
			iter.remove();
			if(wall.y < 8) toAdd.add(new Point(newY, wall.x));
		}
		walls.addAll(toAdd);
	}
	
	private static int bfs() {
		if(walls.size()==0) return 1;
		
		int nextX, nextY;
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(7, 0));
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				Point cur = queue.poll();
				if(walls.contains(new Point(cur.y, cur.x))) continue;
				if(cur.y == 0 && cur.x==7) return 1;

				for(int j=0; j<9; j++) {
					nextX = cur.x+dirX[j];
					nextY = cur.y+dirY[j];
					if(range(nextY, nextX)) {
						Point next = new Point(nextY, nextX);
						if(!walls.contains(new Point(nextY-1, nextX)) && !walls.contains(next)) {
							queue.add(next);
						}
					}
				}	
			}
			moveWalls();
		}
		return 0;
	}
}
