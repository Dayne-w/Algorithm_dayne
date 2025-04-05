import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static HashMap<Integer, Integer> problemMap = new HashMap<>();
    static TreeSet<Pair> problemSet = new TreeSet<>((o1, o2) -> {
        if(o1.level == o2.level){
            return o1.pNum - o2.pNum;
        }
        return o1.level - o2.level;
    });
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int problemNum = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            problemSet.add(new Pair(problemNum, level));
            problemMap.put(problemNum, level);
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("recommend")) {
                if(st.nextToken().equals("-1")) {
                    answerSB.append(problemSet.first().pNum).append('\n');
                }else {
                    answerSB.append(problemSet.last().pNum).append('\n');
                }
            }

            if(command.equals("add")) {
                int problemNum = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                problemSet.add(new Pair(problemNum, level));
                problemMap.put(problemNum, level);
            }

            if(command.equals("solved")) {
                int problemNum = Integer.parseInt(st.nextToken());
                int level = problemMap.get(problemNum);
                problemSet.remove(new Pair(problemNum, level));
                problemMap.remove(problemNum);
            }
        }

        System.out.print(answerSB);
    }

    public static class Pair {
        public int pNum;
        public int level;

        public Pair (int pNum, int level) {
            this.pNum = pNum;
            this.level = level;
        }
    }
}