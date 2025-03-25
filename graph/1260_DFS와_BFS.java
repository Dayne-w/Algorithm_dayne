import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N, M, V;
    static int a, b; // 이어진 정점들 입력 받을 변수, 무방향
    static boolean[] visited = new boolean[1001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i <= N; i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        dfs(V);
        sb.append('\n');
        Arrays.fill(visited, false);
        bfs(V);

        System.out.print(sb);

    }

    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for(int n : graph.get(v)) {
            if(!visited[n]) {
                dfs(n);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[v] = true;
        q.add(v);
        while(!q.isEmpty()) {
            int temp = q.remove();
            sb.append(temp).append(" ");
            for(int n : graph.get(temp)) {
                if(!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
    }

}