import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int inputNum = Integer.parseInt(br.readLine());

            if(inputNum == 0) {
                if(q.isEmpty()) {
                    answerSB.append("0").append('\n');
                    continue;
                }
                answerSB.append(q.remove()).append('\n');
                continue;
            }

            q.add(inputNum);
        }

        System.out.print(answerSB.toString());
    }
}