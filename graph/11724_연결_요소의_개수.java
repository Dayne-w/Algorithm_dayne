import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N, M;
    static int a, b; // 이어진 정점들 입력 받을 변수, 무방향
    static int answer = 0;
    static boolean[] visited = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i);
            }
        }

        System.out.print(answer);

    }

    public static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[v] = true;
        q.add(v);
        while(!q.isEmpty()) {
            int temp = q.remove();
            for(int n : graph.get(temp)) {
                if(!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }

    }
}