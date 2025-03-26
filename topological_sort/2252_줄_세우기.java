import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int a, b;
    static int[] indegree = new int[32001];
    static ArrayList<ArrayList<Integer>> arr= new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            indegree[b]++;
        }

        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        topologicalSort();

        System.out.print(sb);
    }

    public static void topologicalSort() {
        while(!q.isEmpty()) {
            int num = q.remove();
            sb.append(num).append(" ");
            for(int n : arr.get(num)) {
                indegree[n]--;
                if(indegree[n] == 0) q.add(n);
            }
        }
    }
}