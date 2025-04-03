import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] totalSum = new int[100001];
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            totalSum[i] = totalSum[i-1] + Integer.parseInt(st.nextToken());
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            answerSB.append(totalSum[to]-totalSum[from-1]).append('\n');
        }

        System.out.print(answerSB);
    }
}