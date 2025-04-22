import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] depth;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n+1];
        depth = new int[n+1];

        for(int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
            depth[i] = -1;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        BFS(1);

        for(int n : depth) {
            if(n == 1 || n == 2) answer++;
        }

        System.out.println(answer);
    }

    public static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        depth[n] = 0;
        q.add(n);
        while(!q.isEmpty()) {
            int cur = q.remove();
            for(int i = 0; i < adj[cur].size(); i++) {
                int nxt = adj[cur].get(i);
                if(depth[nxt] == -1) {
                    depth[nxt] = depth[cur] + 1;
                    q.add(nxt);
                }
            }
        }
    }
}