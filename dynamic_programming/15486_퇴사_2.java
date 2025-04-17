import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int MAX = 1500002;
    static int[] dp = new int[MAX];
    static int[][] arr = new int[MAX][2];
    static int next;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N+1; i++ ){
            answer = Math.max(answer, dp[i]);

            int next = i + arr[i][0];

            if(next <= N+1) {
                dp[next] = Math.max(dp[next], answer + arr[i][1]);
            }
        }

        System.out.println(answer);
    }
}