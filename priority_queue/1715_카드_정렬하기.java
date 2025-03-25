import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N;
        int temp = 0;
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();
            answer += a + b;
            pq.add(a+b);
        }
        System.out.print(answer);
    }
}