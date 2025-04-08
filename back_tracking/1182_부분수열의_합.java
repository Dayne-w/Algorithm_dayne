import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int N, S;
    static int answer = 0;
    static int[] arr = new int[20];
    static boolean[] visited = new boolean[20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            backTracking(0, 0, 0, i);
        }

        System.out.print(answer);
    }

    public static void backTracking(int start, int sum, int depth, int size) {
        if(depth == size) {
            if(sum == S) answer++;
            return;
        }

        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sum += arr[i];
                backTracking(i+1, sum, depth+1, size);
                sum -= arr[i];
                visited[i] = false;
            }
        }
    }
}