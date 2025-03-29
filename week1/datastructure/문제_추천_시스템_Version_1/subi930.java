import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subi930 {
    static class Problem implements Comparable<Problem> {
        int pNum, level;

        public Problem(int pNum, int level) {
            this.pNum = pNum;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) return Integer.compare(this.pNum, o.pNum);
            return Integer.compare(this.level, o.level);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Problem)) return false;
            Problem other = (Problem) obj;
            return this.pNum == other.pNum && this.level == other.level;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pNum, level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Problem> pqAsc = new PriorityQueue<>();
        PriorityQueue<Problem> pqDesc = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Problem> active = new HashMap<>(); // 문제번호 → 현재 유효 문제

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l);
            pqAsc.add(problem);
            pqDesc.add(problem);
            active.put(p, problem);
        }

        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    while (!pqAsc.isEmpty()) {
                        Problem top = pqAsc.peek();
                        if (active.containsKey(top.pNum) && active.get(top.pNum).equals(top)) {
                            sb.append(top.pNum).append("\n");
                            break;
                        } else {
                            pqAsc.poll();
                        }
                    }
                } else {
                    while (!pqDesc.isEmpty()) {
                        Problem top = pqDesc.peek();
                        if (active.containsKey(top.pNum) && active.get(top.pNum).equals(top)) {
                            sb.append(top.pNum).append("\n");
                            break;
                        } else {
                            pqDesc.poll();
                        }
                    }
                }
            } else if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(p, l);
                pqAsc.add(problem);
                pqDesc.add(problem);
                active.put(p, problem);
            } else if (command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                active.remove(p);
            }
        }

        System.out.print(sb);
    }
}
