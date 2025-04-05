import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int x;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pq.isEmpty()) {
                    answerSB.append(0).append('\n');
                }else {
                    answerSB.append(pq.remove()).append('\n');
                }
            }else {
                pq.add(x);
            }
        }

        System.out.print(answerSB);
    }
}