package week7.simulation.ZOAC3._10Hyuna;
import java.io.*;
import java.util.*;

public class Main {
    static final String[] keyboard = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
    };

    static Set<Character> leftKeys = new HashSet<>(Arrays.asList(
            'q','w','e','r','t','a','s','d','f','g','z','x','c','v'
    ));

    static Map<Character, Point> keyMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char leftStart = st.nextToken().charAt(0);
        char rightStart = st.nextToken().charAt(0);

        // 키보드 좌표 맵핑
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length(); j++) {
                keyMap.put(keyboard[i].charAt(j), new Point(i, j));
            }
        }

        Point leftPos = keyMap.get(leftStart);
        Point rightPos = keyMap.get(rightStart);

        String input = br.readLine();
        int totalTime = 0;

        for (char c : input.toCharArray()) {
            Point target = keyMap.get(c);
            if (leftKeys.contains(c)) {
                totalTime += getDistance(leftPos, target) + 1;
                leftPos = target;
            } else {
                totalTime += getDistance(rightPos, target) + 1;
                rightPos = target;
            }
        }

        System.out.println(totalTime);
    }

    static int getDistance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
}