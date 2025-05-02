import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            long answer = 0;
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < size; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            while(pq.size() != 1) {
                long num1 = pq.remove();
                long num2 = pq.remove();

                long sum = num1 + num2;

                answer += sum;

                pq.add(sum);
            }

            answerSB.append(answer).append('\n');
        }

        System.out.print(answerSB.toString());
    }
}