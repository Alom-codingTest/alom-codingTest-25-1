package dynamic_programming.선수과목.Uechann;

import java.util.*;
import java.io.*;

class subject {
    int subNum;
    int count;
    List<Integer> preList = new ArrayList<>();

    public subject(int subNum, int count) {
        this.subNum = subNum;
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}

//1H
public class Main {
    public static int i;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int subjectNumber = Integer.parseInt(st.nextToken());   //과목수
        int conditionCount = Integer.parseInt(st.nextToken());  //조건수

        //과목들 리스트 선언
        subject[] subs = new subject[subjectNumber + 1];
        //과목수 + 1만큼 생성
        for (int i = 1; i <= subjectNumber; i++) {
            subs[i] = new subject(i, 1);
        }

        for (i = 1; i <= conditionCount; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            subs[next].preList.add(pre);
        }

        for (i = 1; i <= subjectNumber; i++) {
            if (subs[i].preList.isEmpty()) continue;

            subs[i].preList.forEach(p -> {
                        int max = subs[i].getCount();
                        subs[i].setCount(Math.max(subs[p].getCount() + 1, max));
                    });
        }
        //출력
        //1과목부터 N과목까지 최소 몇학기에 이수할 수 있는지 공백 구분하여 출력
        //1 2 3 -> 1과목은 1학기에 2과목은 2학기에 3과목은 3학기에 이수할 수 있다는 뜻
        for (i = 1; i <= subjectNumber; i++) {
            sb.append(subs[i].count).append(" ");
        }
        System.out.println(sb);
    }
}