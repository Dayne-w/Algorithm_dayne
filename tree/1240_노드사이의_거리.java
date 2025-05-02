import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] adjWeight = new int[1001][1001];
    static ArrayList<Integer>[] adj = new ArrayList[1001];
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 1001; i++) {
            adj[i] = new ArrayList<>();
        }

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
            adjWeight[a][b] = weight;
            adjWeight[b][a] = weight;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            answerSB.append(BFS(start, end)).append('\n');
        }

        System.out.print(answerSB.toString());
    }

    public static int BFS(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[1001];
        Arrays.fill(dist, -1);
        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.remove();
            for(int nxt : adj[cur]) {
                if(dist[nxt] == -1) {
                    q.add(nxt);
                    dist[nxt] = dist[cur] + adjWeight[cur][nxt];
                }
            }
        }

        return dist[end];
    }

}