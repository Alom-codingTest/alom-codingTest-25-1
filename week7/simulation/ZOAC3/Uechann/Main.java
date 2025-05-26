package simulation.ZOAC3.Uechann;

/*문제
독수리 타법이란 양 손의 검지손가락만을 이용해 타자를 치는 타법이다.
성우는 한글 자음 쪽 자판은 왼손 검지손가락으로 입력하고, 한글 모음 쪽 자판은 오른손 검지손가락으로 입력한다.
a의 좌표가 (x1, y1)이고, b의 좌표가 (x2, y2)일 때, a에 위치한 성우의 손가락이 b로 이동하는 데에는 a와 b의 택시 거리 |x1-x2|+|y1-y2| 만큼의 시간이 걸린다.
각 키를 누르는 데에는 1의 시간이 걸린다.
성우는 두 손을 동시에 움직일 수 없다.
성우가 사용하는 키보드는 쿼티식 키보드이며, 아래 그림처럼 생겼다.

바쁜 성우를 위하여 해당 문자열을 출력하는 데 걸리는 시간의 최솟값을 구해보자.

입력
첫 번째 줄에는 두 알파벳 소문자 sL, sR이 주어진다. sL, sR은 각각 왼손 검지손가락, 오른손 검지손가락의 처음 위치이다.
그 다음 줄에는 알파벳 소문자로 구성된 문자열이 주어진다. 문자열의 길이는 최대 100자이다. 빈 문자열은 주어지지 않는다.

출력
입력으로 주어진 문자열을 출력하는 데에 걸리는 시간의 최솟값을 출력한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        char[][] keyboard = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        char sl = st.nextToken().charAt(0); // 왼손 검지손가락의 초기 위치
        char sr = st.nextToken().charAt(0); // 오른손 검지손가락의 초기 위치

        String input = br.readLine(); // 입력 문자열

        int time = 0; // 총 시간 초기화

        for (char c : input.toCharArray()) {
            int[] leftPos = findPosition(keyboard, sl);
            int[] rightPos = findPosition(keyboard, sr);
            int[] targetPos = findPosition(keyboard, c);

            // 모음일 경우 오른손 사용
            if (targetPos[1] >= 5 || Arrays.equals(targetPos, new int[]{2, 4})) {
                int rightTime = Math.abs(rightPos[0] - targetPos[0]) + Math.abs(rightPos[1] - targetPos[1]);
                sr = c; // 오른손 위치 업데이트
                time += rightTime + 1;// 오른손 이동 시간 + 1 (키 누르는 시간)
            }
            else{//자음일 경우 왼손 사용
                int leftTime = Math.abs(leftPos[0] - targetPos[0]) + Math.abs(leftPos[1] - targetPos[1]);
                time += leftTime + 1;// 왼손 이동 시간 + 1 (키 누르는 시간)
                sl = c; // 왼손 위치 업데이트
            }
        }

        System.out.println(time); // 총 시간 출력
    }

    private static int[] findPosition(char[][] keyboard, char c) {
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                if (keyboard[i][j] == c) {
                    return new int[]{i, j}; // 행, 열 반환
                }
            }
        }
        return null;
    }
}
